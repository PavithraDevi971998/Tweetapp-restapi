package com.tweetapp.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document

public class Tweets {
	
	@Field("tweetId")
	private int tweetId;
	@Size(min=2,message="User Name should have atleast 3 characters")
	private String userName;
	@Email(message = "Email should be valid")
	private String emailId;
	private String originaltweet;
	private String tweettime;
	@Size(max = 144, message = "replyTweet tweet should not exceed 144 characters")
	private String replyTweet;
	public Tweets(int tweetId, @Size(min = 2, message = "User Name should have atleast 3 characters") String userName,
			@Email(message = "Email should be valid") String emailId, String originaltweet, String tweettime,
			@Size(max = 144, message = "replyTweet tweet should not exceed 144 characters") String replyTweet) {
		super();
		this.tweetId = tweetId;
		this.userName = userName;
		this.emailId = emailId;
		this.originaltweet = originaltweet;
		this.tweettime = tweettime;
		this.replyTweet = replyTweet;
	}
	public int getTweetId() {
		return tweetId;
	}
	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getOriginaltweet() {
		return originaltweet;
	}
	public void setOriginaltweet(String originaltweet) {
		this.originaltweet = originaltweet;
	}
	public String getTweettime() {
		return tweettime;
	}
	public void setTweettime(String tweettime) {
		this.tweettime = tweettime;
	}
	public String getReplyTweet() {
		return replyTweet;
	}
	public void setReplyTweet(String replyTweet) {
		this.replyTweet = replyTweet;
	}
	@Override
	public String toString() {
		return "Tweets [tweetId=" + tweetId + ", userName=" + userName + ", emailId=" + emailId + ", originaltweet="
				+ originaltweet + ", tweettime=" + tweettime + ", replyTweet=" + replyTweet + "]";
	}
	
	
}
