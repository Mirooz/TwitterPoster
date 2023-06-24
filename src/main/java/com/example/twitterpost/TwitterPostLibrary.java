package com.example.twitterpost;


import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TwitterPostLibrary {

    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String accessTokenSecret;
    private String tweetText;
    private String imagePath;

    private TwitterPostLibrary() {
        // Le constructeur est privé pour imposer l'utilisation du builder
    }

    public static Builder builder() {
        return new Builder();
    }



    public static class Builder {
        private TwitterPostLibrary instance;

        private Builder() {
            instance = new TwitterPostLibrary();
        }

        public Builder consumerKey(String consumerKey) {
            instance.consumerKey = consumerKey;
            return this;
        }

        public Builder consumerSecret(String consumerSecret) {
            instance.consumerSecret = consumerSecret;
            return this;
        }

        public Builder accessToken(String accessToken) {
            instance.accessToken = accessToken;
            return this;
        }

        public Builder accessTokenSecret(String accessTokenSecret) {
            instance.accessTokenSecret = accessTokenSecret;
            return this;
        }

        public Builder tweetText(String tweetText) {
            instance.tweetText = tweetText;
            return this;
        }

        public Builder imagePath(String imagePath) {
            instance.imagePath = imagePath;
            return this;
        }

        public TwitterPostLibrary build() {
            return instance;
        }
    }
}
