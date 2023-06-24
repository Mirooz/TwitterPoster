package com.example.twitterpost;

import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.TwitterCredentialsOAuth1;
import com.twitter.clientlib.api.TwitterApi;
import com.twitter.clientlib.model.CreateTweetRequest;
import com.twitter.clientlib.model.CreateTweetRequestMedia;
import com.twitter.clientlib.model.CreateTweetRequestPoll;
import com.twitter.clientlib.model.TweetCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.UploadedMedia;

import java.io.File;
import java.util.Arrays;
import java.util.List;
@Component
public class TwitterPoster {

    @Autowired
    private TwitterApiManager apiManager;


    public void postTweet(String tweetText, File imageFile) throws TwitterException {
        apiManager.setTwitterCredentials();

        // Set the params values
        CreateTweetRequest createTweetRequest = new CreateTweetRequest();

        // The text of the Tweet
        createTweetRequest.text(tweetText);



        File imagefile = new File("lol2.png");

        String[] mediaIds = new String[1];


        // Attach the image to the Tweet

        try {
            TweetCreateResponse result = apiManager.createTweet(createTweetRequest);
            if (result != null) {
                System.out.println(result);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
