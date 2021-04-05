package com.chc.challenge.twitter.configuration;

import com.chc.challenge.twitter.configuration.TwitterListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.FilterQuery;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;


import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class TwitterConfig {

    @Autowired
    TwitterListener twitterListener;

    @PostConstruct
    public void configTwitterStream(){
        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
        FilterQuery tweetFilterQuery = new FilterQuery();
        tweetFilterQuery.track(new String[]{"#","coronavirus","covid"});
        tweetFilterQuery.follow(new long[]{1500L});
        tweetFilterQuery.language(new String[]{"es","it"});
        twitterStream.addListener(twitterListener);
        twitterStream.filter(tweetFilterQuery);


    }





}
