package com.chc.challenge.twitter.webSocket;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import twitter4j.Status;
@Getter
public class TwitterEstadoRecibido extends ApplicationEvent {

    private final Status status;
    public TwitterEstadoRecibido(Object source, Status status) {
        super(source);
        this.status = status;
    }
}
