package com.chc.challenge.twitter.webSocket;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import twitter4j.Status;
@Getter
public class TwitterEstadoRecivido extends ApplicationEvent {
//recuperamos el objeto
    private final Status status;
    public TwitterEstadoRecivido(Object source,Status status) {
        super(source);
        this.status = status;
    }
}
