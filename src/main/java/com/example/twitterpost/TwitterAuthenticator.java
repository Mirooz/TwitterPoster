package com.example.twitterpost;

import com.twitter.clientlib.TwitterCredentialsOAuth1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwitterAuthenticator {

    @Value("${twitter.consumerKey}")
    private String consumerKey;

    @Value("${twitter.consumerSecret}")
    private String consumerSecret;

    @Value("${twitter.accessToken}")
    private String accessToken;

    @Value("${twitter.accessTokenSecret}")
    private String accessTokenSecret;

    public TwitterCredentialsOAuth1 getCredentials() {
        return new TwitterCredentialsOAuth1(consumerKey, consumerSecret, accessToken, accessTokenSecret);
    }
}
