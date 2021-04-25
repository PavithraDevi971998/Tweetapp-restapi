package com.tweetapp.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.domain.Tweets;
import com.tweetapp.domain.UserTweets;
@Repository
public interface UserTweetDao extends MongoRepository<Tweets,Integer> {

	Tweets save(@Valid Tweets tweets);

	List<Tweets> findByUserName(String username);
    
	
}
