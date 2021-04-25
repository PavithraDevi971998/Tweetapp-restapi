package com.tweetapp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.domain.Like;
import com.tweetapp.domain.Register;

@Repository
public interface LikeDao extends MongoRepository<Like,Integer> {

	Like findByTweetIdAndEmail(String tweetid, String email);

	Like save(Like like);

}
