package com.chc.challenge.twitter.configuration;


import com.chc.challenge.twitter.service.FilterService;
import com.chc.challenge.twitter.webSocket.TwitterEstadoRecibido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

@Component
@Slf4j
public class TwitterListener implements StatusListener {

    @Autowired
    FilterService filterService;

    private ApplicationEventPublisher applicationEventPublisher;

    public TwitterListener(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void onStatus(Status status) {
        TwitterEstadoRecibido estadoRecibido = new TwitterEstadoRecibido(this, status);
        applicationEventPublisher.publishEvent(estadoRecibido);
        log.info("Evento emitido con id: " + status.getId());
        filterService.saveFilterTweets(status);
    }


    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    @Override
    public void onTrackLimitationNotice(int i) {

    }

    @Override
    public void onScrubGeo(long l, long l1) {

    }

    @Override
    public void onStallWarning(StallWarning stallWarning) {

    }

    @Override
    public void onException(Exception e) {

    }
}
