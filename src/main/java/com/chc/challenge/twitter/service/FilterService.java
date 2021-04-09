package com.chc.challenge.twitter.service;

import com.chc.challenge.twitter.entity.TweetEntity;
import com.chc.challenge.twitter.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Status;

@Service
public class FilterService {
    @Autowired
    TweetRepository tweetRepository;

    public void saveFilterTweets(Status status) {
        TweetEntity tweetEntity = new TweetEntity();
        if (status.getUser().getFollowersCount() > 1500) {
            tweetEntity.setUsuario(status.getUser().getScreenName());
            tweetEntity.setMsg(status.getText());
            if (status.getUser().getLocation() != null) {
                tweetEntity.setLocalizacion(status.getUser().getLocation());
            }
            else {
                tweetEntity.setLocalizacion("Desconocido");
            }
            if (status.getUser().isVerified()) {
                tweetEntity.setValidacion(true);
            }
            tweetRepository.save(tweetEntity);
        }
    }

}
