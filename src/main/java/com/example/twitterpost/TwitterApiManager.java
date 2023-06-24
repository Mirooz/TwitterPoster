package com.example.twitterpost;

import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.TwitterCredentialsOAuth1;
import com.twitter.clientlib.api.TwitterApi;
import com.twitter.clientlib.model.CreateTweetRequest;
import com.twitter.clientlib.model.TweetCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TwitterApiManager {

    private TwitterApi apiInstance;

    @Autowired
    private TwitterAuthenticator authenticator;

    public TwitterApiManager() {
        apiInstance = new TwitterApi();
    }

    public void setTwitterCredentials() {

        // Retrieve auth credentials
        TwitterCredentialsOAuth1 credentials = authenticator.getCredentials();

        // Pass credentials to library client
        apiInstance.setTwitterCredentials(credentials);
    }

    public TweetCreateResponse createTweet(CreateTweetRequest createTweetRequest) {
        try {
            return apiInstance.tweets().createTweet(createTweetRequest);
        } catch (ApiException e) {
            System.err.println("Exception when calling TweetsApi#createTweet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
