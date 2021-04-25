package com.tweetapp.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserTweets {
	
	  @Id 
	  private int tweetId;
	@Size(min=2,message="User Name should have atleast 3 characters")
	private String name;
	@Email(message = "Email should be valid")
	private String emailId;
	@Size(max=144,message="tweetText should not exceed 144 characters")
	private String tweetText;
	private String tweettime;
	public UserTweets(int tweetId, @Size(min = 2, message = "User Name should have atleast 3 characters") String name,
			@Email(message = "Email should be valid") String emailId,
			@Size(max = 144, message = "tweetText should not exceed 144 characters") String tweetText,
			String tweettime) {
		super();
		this.tweetId = tweetId;
		this.name = name;
		this.emailId = emailId;
		this.tweetText = tweetText;
		this.tweettime = tweettime;
	}
	public int gettweetId() {
		return tweetId;
	}
	public void settweetId(int tweetId) {
		this.tweetId = tweetId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getTweetText() {
		return tweetText;
	}
	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}
	public String getTweettime() {
		return tweettime;
	}
	public void setTweettime(String tweettime) {
		this.tweettime = tweettime;
	}
	@Override
	public String toString() {
		return "UserTweets [tweetId=" + tweetId + ", name=" + name + ", emailId=" + emailId + ", tweetText="
				+ tweetText + ", tweettime=" + tweettime + "]";
	}
	
}
