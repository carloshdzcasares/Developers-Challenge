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
public class SpringConfig {
    @Bean
    TwitterStreamFactory twitterStreamFactory() {
        return new TwitterStreamFactory();
    }

    @Bean
    TwitterStream twitterStream(TwitterStreamFactory twitterStreamFactory) {
        return twitterStreamFactory.getInstance();
    }


}
