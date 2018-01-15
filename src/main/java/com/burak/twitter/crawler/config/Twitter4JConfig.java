package com.burak.twitter.crawler.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class Twitter4JConfig {

    @Value("${spring.social.twitter.app-id}")
    private String consumerKey;

    @Value("${spring.social.twitter.app-secret}")
    private String consumerKeySecret;

    @Value("${spring.social.twitter.access-token}")
    private String accessToken;

    @Value("${spring.social.twitter.access-token-secret}")
    private String accessTokenSecret;

    @Bean(name = "twitter4j")
    public Twitter twitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerKeySecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);

        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }
}
