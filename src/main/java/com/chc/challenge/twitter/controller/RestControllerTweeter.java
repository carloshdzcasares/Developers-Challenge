package com.chc.challenge.twitter.controller;


import com.chc.challenge.twitter.entity.TweetEntity;
import com.chc.challenge.twitter.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/twitter")
public class RestControllerTweeter {

/*    static final String TWEETER = "/api/twitter";
    static final String TWEET = RestControllerTweeter.TWEETER+"/tweets";*/


    private TweetService tweetServiceImp;
    @Autowired
    public RestControllerTweeter(TweetService tweetServiceImp) {
        this.tweetServiceImp = tweetServiceImp;
    }

    @GetMapping("/tweets")
    public List<TweetEntity> getAllTweets(){
        return tweetServiceImp.findAll();
    }

    @PutMapping("/tweet/{id}")
    public ResponseEntity<TweetEntity> modificarValidacion(@RequestBody TweetEntity tweetEntity, @PathVariable Long id){
        TweetEntity tweetEntityUpdate = tweetServiceImp.marcarValido(tweetEntity, id);
            return new ResponseEntity<>(tweetEntityUpdate, HttpStatus.OK);
    }
    @GetMapping("/tweets/validados")
    public List<TweetEntity> getAllTweetsValidos(){
        return tweetServiceImp.findByValidacion();
    }

}
