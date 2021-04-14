package com.chc.challenge.twitter.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;


import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class TwitterConfig {

    @Autowired
    TwitterListener twitterListener;
    TwitterStream twitterStream;

    @PostConstruct
    public void autentication(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(System.getenv("Dtwitter4j.oauth.consumerKey"))
                .setOAuthConsumerSecret(System.getenv("Dtwitter4j.oauth.consumerSecret"))
                .setOAuthAccessToken(System.getenv("Dtwitter4j.oauth.accessToken"))
                .setOAuthAccessTokenSecret(System.getenv("Dtwitter4j.oauth.accessTokenSecret"));
        TwitterStreamFactory tsf =new TwitterStreamFactory(cb.build());
        twitterStream = tsf.getInstance();
        configTwitterStream();
    }

    public void configTwitterStream(){
        FilterQuery tweetFilterQuery = new FilterQuery();
        tweetFilterQuery.track(new String[]{"#","coronavirus","covid"});
        tweetFilterQuery.follow(new long[]{1500L});
        tweetFilterQuery.language(new String[]{"es","it"});
        twitterStream.addListener(twitterListener);
        twitterStream.filter(tweetFilterQuery);


    }





}
