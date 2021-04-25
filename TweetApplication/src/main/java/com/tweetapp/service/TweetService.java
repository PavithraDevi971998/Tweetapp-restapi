package com.tweetapp.service;

import java.util.List;

import javax.validation.Valid;

import com.tweetapp.domain.Like;
import com.tweetapp.domain.Register;
import com.tweetapp.domain.Tweets;
import com.tweetapp.domain.UserTweets;

public interface TweetService {

	Boolean save( UserTweets userTweets);

	List<UserTweets> findAll();

	List<Tweets> findByUserName(String username);
	UserTweets findByName(String username);

	Boolean save(Tweets tweets);

	Boolean deleteByName(String username);

	Like findByTweetIdAndEmail(String tweetid, String email);

	Boolean save(Like like);


}
