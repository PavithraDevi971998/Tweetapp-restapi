package com.tweetapp.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Like {
	private String tweetId;
	private String tweetText;
	private String email;
	private String likeStatus;
	public Like(String tweetId, String tweetText, String email, String likeStatus) {
		super();
		this.tweetId = tweetId;
		this.tweetText = tweetText;
		this.email = email;
		this.likeStatus = likeStatus;
	}
	public String getTweetId() {
		return tweetId;
	}
	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}
	public String getTweetText() {
		return tweetText;
	}
	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getLikeStatus() {
		return likeStatus;
	}
	public void setLikeStatus(String likeStatus) {
		this.likeStatus = likeStatus;
	}
	@Override
	public String toString() {
		return "Like [tweetId=" + tweetId + ", tweetText=" + tweetText + ", email=" + email + ", likeStatus="
				+ likeStatus + "]";
	}

}
