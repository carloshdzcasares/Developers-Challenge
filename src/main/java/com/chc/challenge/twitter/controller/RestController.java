package com.chc.challenge.twitter.controller;


import com.chc.challenge.twitter.models.Tweet;
import com.chc.challenge.twitter.service.TweetServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/twitter")
public class RestController {
    @Autowired
    TweetServiceImp tweetServiceImp;

    @GetMapping("/tweets")
    public List<Tweet> getAllTweets(){
        return tweetServiceImp.findAll();
    }

    @PutMapping("/tweet/{id}")
    public ResponseEntity<Tweet> modificarValidacion(@RequestBody Tweet tweet, @PathVariable Long id){
        Tweet tweetUpdate = null;
        Tweet tweetActual = tweetServiceImp.marcarValido(tweet, id);
        try{
            tweetUpdate = tweetServiceImp.save(tweetActual);
        }catch (DataAccessException e){
            e.printStackTrace();
        }
            return new ResponseEntity<>(tweetUpdate,HttpStatus.OK);
    }
    @GetMapping("/tweets/validados")
    public List<Tweet> getAllTweetsValidos(){
        return tweetServiceImp.findByValidacion();
    }

}
