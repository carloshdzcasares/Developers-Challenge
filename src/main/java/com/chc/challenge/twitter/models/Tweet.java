package com.chc.challenge.twitter.models;

import lombok.Data;
import twitter4j.GeoLocation;


import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tweet")
public class Tweet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String msg;
    private String usuario;
    private String localizacion;
    private boolean validacion;

}
