package com.chc.challenge.twitter.repository;

import com.chc.challenge.twitter.entity.TweetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<TweetEntity,Long> {

    List<TweetEntity> findAllByValidacionIsTrue();

}
