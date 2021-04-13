package com.chc.challenge.twitter.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;


@Configuration
@PropertySource("classpath:twitter4j.properties")
public class SpringConfig {
    @Value("${oauth.consumerKey}")
    private String consumerKey;
    @Value("${oauth.consumerSecret}")
    private String consumerSecret;
    @Value("${oauth.accessToken}")
    private String oAuthAccessToken;
    @Value("${oauth.accessTokenSecret}")
    private String oAuthAccessTokenSecret;
    @Bean
    TwitterStreamFactory twitterStreamFactory() {
        return new TwitterStreamFactory();
    }

    @Bean
    TwitterStream twitterStream(TwitterStreamFactory twitterStreamFactory) {
        return twitterStreamFactory.getInstance();
    }

    public void configuracionKeys(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(oAuthAccessToken)
                .setOAuthAccessTokenSecret(oAuthAccessTokenSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
    }


}
