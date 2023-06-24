package com.example.twitterpost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwitterPostApplication {

    public static void main(String[] args) {
        TwitterPostLibrary library = TwitterPostLibrary.builder().build();

    }
}


