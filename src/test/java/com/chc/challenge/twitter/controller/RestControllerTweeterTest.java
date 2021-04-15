/*package com.chc.challenge.twitter.controller;


import com.chc.challenge.twitter.entity.TweetEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest
public class RestControllerTweeterTest {

    @Autowired
    RestControllerTweeter restControllerTweeter;
    @Test
    void testUpdateTweetValidationHttpStatusCodeOK(){
        TweetEntity tweetEntity = new TweetEntity();
        tweetEntity.setId(1L);
        tweetEntity.setLocalizacion("Madrid");
        tweetEntity.setValidacion(false);
        tweetEntity.setMsg("Texto");
        tweetEntity.setUsuario("Carlos");
        ResponseEntity<TweetEntity> responseEntity = restControllerTweeter.modificarValidacion(tweetEntity,1L);
        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }
    @Test
    void TestUpdateTweetValidation(){
        TweetEntity tweetEntityMandado = new TweetEntity();
        tweetEntityMandado.setId(1L);
        tweetEntityMandado.setLocalizacion("Madrid");
        tweetEntityMandado.setValidacion(false);
        tweetEntityMandado.setMsg("Texto");
        tweetEntityMandado.setUsuario("Carlos");

       TweetEntity tweetEntityEsperado = new TweetEntity();
        tweetEntityEsperado.setId(1L);
        tweetEntityEsperado.setLocalizacion("Madrid");
        tweetEntityEsperado.setValidacion(true);
        tweetEntityEsperado.setMsg("Texto");
        tweetEntityEsperado.setUsuario("Carlos");

        ResponseEntity<TweetEntity> responseEntityModif = restControllerTweeter.modificarValidacion(tweetEntityMandado,null);

       Assertions.assertEquals(tweetEntityEsperado,responseEntityModif.getBody());
    }

}*/

