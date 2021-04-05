package com.chc.challenge.twitter.service;

import com.chc.challenge.twitter.models.Tweet;
import com.chc.challenge.twitter.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import twitter4j.Status;
import twitter4j.TweetEntity;

import java.util.List;
import java.util.Optional;

@Service
public class TweetServiceImp {
    @Autowired
    TweetRepository tweetRepository;



    @Transactional(readOnly = true)
    public List<Tweet> findAll() {
        return tweetRepository.findAll();
    }

    @Transactional
    public Tweet marcarValido(Tweet tweet,Long id) {
        Tweet tweetActual = tweetRepository.findById(id).orElse(null);
        if(tweetActual == null){
            return tweetActual;
        }
        if(!tweetActual.isValidacion()){
            tweetActual.setValidacion(true);
        }

        return tweetActual;
    }
    @Transactional
    public Tweet save(Tweet tweet){
        return  tweetRepository.save(tweet);

    }

    @Transactional
    public List<Tweet> findByValidacion() {
        return tweetRepository.findAllByValidacionIsTrue();
    }

    public void saveFilterTweets(Status status) {
        System.out.println("ESTATUS DESDE EL SERVICE: " + status);
        Tweet tweet = new Tweet();
        if (status.getUser().getFollowersCount() > 1500) {
            tweet.setUsuario(status.getUser().getScreenName());
            tweet.setMsg(status.getText());
            if(status.getUser().getLocation() != null){
                tweet.setLocalizacion(status.getUser().getLocation());
            }else{
                tweet.setLocalizacion("Desconocido");
            }
            if (status.getUser().isVerified()) {
                tweet.setValidacion(true);
            }else{
                tweet.setValidacion(false);
            }
            tweetRepository.save(tweet);
        }


    }
}
