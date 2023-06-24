package com.example.twitterpost;

import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.TwitterCredentialsBearer;
import com.twitter.clientlib.TwitterCredentialsOAuth1;
import com.twitter.clientlib.api.TwitterApi;
import com.twitter.clientlib.model.CreateTweetRequest;
import com.twitter.clientlib.model.CreateTweetRequestPoll;
import com.twitter.clientlib.model.TweetCreateResponse;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import twitter4j.TwitterException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@SpringBootTest
class TwitterPostApplicationTests {

    TwitterPostLibrary library;

    @Test
    void contextLoads() {
    }

    @BeforeEach
    void builder() {

        library = TwitterPostLibrary.builder()
                .consumerKey(consumerKey)
                .consumerSecret(consumerSecret)
                .accessToken(accessToken)
                .accessTokenSecret(accessTokenSecret)
                .tweetText("Test")
                .imagePath("lol2.png")
                .build();

        Assertions.assertNotNull(library);

    }


    String consumerKey = "vZC5H6rc5tXjQvoHH5FrohKe2";
    String consumerSecret = "xchEhSe4ZvQOC5MeiE7sau7DQ2tW60Rzq0PczYQoYsKm6LpxxL";
    String accessToken = "1660706061836230665-IucTaxAecnkKI8k6tci60ybgCsfhzK";
    String accessTokenSecret = "2N9FfS7QGEp1Ga1JFa1nqtbJJiAw8AyQaLRgU6Ru1EtJz";
    String bearer = "AAAAAAAAAAAAAAAAAAAAAOqYoQEAAAAA9%2FfiN%2FR2BqeeFhri8xUdczQJwiU%3DDf5B3T4oihuqvtqfUXzxjUY1LreR1u8OKzdSWOi5hNewL1SLUk";
    String Clientid = "U1p6enlROEFmUm44SDhUckNqNk46MTpjaQ";
    String ClientSecret = "09X5Jr3t_7MkjZ--qJPS489Z7_yWPs8hIuhWPf0bHJaAfrQrKI";


    @Test
    public void testLib() {
        // Instantiate library client
        TwitterApi apiInstance = new TwitterApi();

// Instantiate auth credentials (App-only example)



        TwitterCredentialsOAuth1 credentials = new TwitterCredentialsOAuth1(consumerKey, consumerSecret, accessToken, accessTokenSecret);

// Pass credentials to library client
        apiInstance.setTwitterCredentials(credentials);
        // Set the params values

        CreateTweetRequest createTweetRequest = new CreateTweetRequest();
        CreateTweetRequestPoll createTweetRequestPoll = new CreateTweetRequestPoll();

// The text of the Tweet
        createTweetRequest.text("Test api");

// Options for a Tweet with a poll
        List<String> pollOptions = Arrays.asList("Yes", "Maybe", "No");
        createTweetRequestPoll.options(pollOptions);

// Duration of the poll in minutes
        createTweetRequestPoll.durationMinutes(120);

        createTweetRequest.poll(createTweetRequestPoll);

        try {
            TweetCreateResponse result = apiInstance.tweets().createTweet(createTweetRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TweetsApi#createTweet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Autowired
    private TwitterPoster twitterPoster;
    @Test
    public void testPostTwitter() throws TwitterException {

        twitterPoster.postTweet("testapi",new File("lol2.png"));
    }
}
