package com.tweetapp.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.dao.LikeDao;
import com.tweetapp.dao.TweetDao;
import com.tweetapp.dao.UserTweetDao;
import com.tweetapp.domain.Like;
import com.tweetapp.domain.Tweets;
import com.tweetapp.domain.UserTweets;

@Service
public class TweetServiceImpl implements TweetService{

	@Autowired
	TweetDao tweetDao;
	@Autowired
	UserTweetDao userTweetDao;
	@Autowired
	LikeDao likeDao;
	@Override
	public Boolean save(UserTweets userTweets) {
		Boolean response;
		UserTweets result=tweetDao.save(userTweets);
		if(null!=result)
		{
			response=true;
		}
		else {
			response=false;
		}
	return response;
	}
	@Override
	public List<UserTweets> findAll() {
		// TODO Auto-generated method stub
		return tweetDao.findAll();
	}
	@Override
	public List<Tweets> findByUserName(String username) {
		// TODO Auto-generated method stub
		return userTweetDao.findByUserName(username);
	}
	@Override
	public Boolean save(@Valid Tweets tweets) {
		Boolean response;
		Tweets result=userTweetDao.save(tweets);
		if(null!=result)
		{
			response=true;
		}
		else {
			response=false;
		}
	return response;
	}
	@Override
	public UserTweets findByName(String username) {
		// TODO Auto-generated method stub
		return tweetDao.findByName(username);
	}
	@Override
	public Boolean deleteByName(String username) {
		Boolean response;
		UserTweets result=tweetDao.deleteByName(username);
		if(null!=result)
		{
			response=true;
		}
		else {
			response=false;
		}
	return response;
	
	}
	@Override
	public Like findByTweetIdAndEmail(String tweetid, String email) {
		// TODO Auto-generated method stub
		return likeDao.findByTweetIdAndEmail(tweetid,email);
	}
	@Override
	public Boolean save(Like like) {
		Boolean response;
		Like result=likeDao.save(like);
		if(null!=result)
		{
			response=true;
		}
		else {
			response=false;
		}
	return response;
	}

	
}
