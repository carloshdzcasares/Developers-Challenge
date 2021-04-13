package com.chc.challenge.twitter.webSocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class WebSocketHandler extends TextWebSocketHandler implements ApplicationListener<TwitterEstadoRecibido> {

    private Map<String,WebSocketSession> sessions = new ConcurrentHashMap<>();
    private ObjectWriter objectWritter;

    public WebSocketHandler ( ObjectMapper objectMapper){
        this.objectWritter = objectMapper.writerWithDefaultPrettyPrinter();
    }

    @Override
    public void onApplicationEvent(TwitterEstadoRecibido twitterEstadoRecibido) {
        try{
            String msg = objectWritter.writeValueAsString(twitterEstadoRecibido);
            sendMessageToAll(msg);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        sessions.put(session.getId(),session);
    }
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);

        log.error("Error en el remitente"+ session,exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        sessions.remove(session.getId());
    }

    private void sendMessageToAll(String mensaje){
        TextMessage textMessage = new TextMessage(mensaje);
        System.out.println("Socket HERE");
        sessions.forEach((key,value) ->{
            try{
                System.out.println("Socket" + mensaje+" "+key +" Value "+ value);
                value.sendMessage(textMessage);

                log.info("Enviar mensaje al socketID: "+mensaje,key);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
    }

}
