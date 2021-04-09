package com.chc.challenge.twitter.models;

import lombok.Data;

@Data
public class TweetDTO {

    private Long id;
    private String msg;
    private String usuario;
    private String localizacion;
    private boolean validacion;
}
