package com.chc.challenge.twitter.repository;

import com.chc.challenge.twitter.models.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet,Long> {

    List<Tweet> findAllByValidacionIsTrue();

}
