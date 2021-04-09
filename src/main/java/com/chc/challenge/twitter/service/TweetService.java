package com.chc.challenge.twitter.service;

import com.chc.challenge.twitter.entity.TweetEntity;
import com.chc.challenge.twitter.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TweetService {
    @Autowired
    TweetRepository tweetRepository;
    @Transactional(readOnly = true)
    public List<TweetEntity> findAll() {
        return tweetRepository.findAll();
    }

    @Transactional
    public TweetEntity marcarValido(TweetEntity tweetEntity, Long id) {
        TweetEntity tweetEntityActual = tweetRepository.findById(id).orElse(null);
        TweetEntity tweetEntityUpdated = null;
        if(tweetEntityActual == null){
            return tweetEntityActual;
        }
        if(!tweetEntityActual.isValidacion()){
            tweetEntityActual.setValidacion(true);
        }
        try{
            tweetEntityUpdated = save(tweetEntityActual);
        }catch (DataAccessException e){
            e.printStackTrace();
        }
        return tweetEntityUpdated;
    }
    @Transactional
    public TweetEntity save(TweetEntity tweetEntity){
        return  tweetRepository.save(tweetEntity);

    }

    @Transactional(readOnly = true)
    public List<TweetEntity> findByValidacion() {
        return tweetRepository.findAllByValidacionIsTrue();
    }


}
