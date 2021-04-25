package com.tweetapp.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.tweetapp.domain.ExceptionResponse;
import com.tweetapp.domain.Like;
import com.tweetapp.domain.Tweets;
import com.tweetapp.domain.UserTweets;
import com.tweetapp.service.TweetService;
@RestController
public class TweetController {
	
	@Autowired
	TweetService tweetService;
	@RequestMapping( value = "/addTweet", method = RequestMethod.POST)
	public String getUserDetails(@Valid @RequestBody UserTweets userTweets) {
		String response;
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();    
		userTweets.setTweettime(dtf.format(now));
		Boolean result=tweetService.save(userTweets);
		if(result) {
			response="Details registered successfully";
		}
		else {
			response="Details not registered successfully";
		}
		return response;
		
}
	@RequestMapping( value = "/addUserTweet", method = RequestMethod.POST)
	public String getUserTweets(@Valid @RequestBody Tweets tweets) {
		String response;
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();    
		   tweets.setTweettime(dtf.format(now));
		Boolean result=tweetService.save(tweets);
		if(result) {
			response="Details registered successfully";
		}
		else {
			response="Details not registered successfully";
		}
		return response;
		
}
	@RequestMapping( value = "/tweets/all", method = RequestMethod.GET)
	public List<UserTweets> getTweets() {	
		return tweetService.findAll();
	}
	@PutMapping("/tweet/{username}")
	public String updatedetails(@PathVariable String username,@RequestBody UserTweets userTweets){
		UserTweets tweet= tweetService.findByName(username);
		String response;
		if(tweet!=null) {
			String tweetUser=userTweets.getTweetText();
			tweet.setTweetText(tweetUser);
			Boolean result=tweetService.save(tweet);
			if(result) {
				response="Details updated successfully";
			}
			else {
				response="Details not updated ";
			}
		}
		else {
			response="Details not found for user";
		}
		return response;
	}
	@RequestMapping( value = "/tweets/all/{username}", method = RequestMethod.GET)
	public List<Tweets> getSpecificUsers(@PathVariable String username) {	
		return tweetService.findByUserName(username);
	}
	@DeleteMapping( value = "/tweets/delete/{username}")
	public String deleteSpecificUsers(@PathVariable String username) {	
		String response;
		Boolean result= tweetService.deleteByName(username);
		if(result) {
			response="Details deleted successfully";
		}
		else {
			response="Details not deleted ";
		}
		return response;
		
	}
	
	@RequestMapping(value = "/addLike", method = RequestMethod.POST)
	public String getLikeDetails( @RequestBody Like like) {
		String response;
		String tweetid =like.getTweetId(); 
		String likestatus = like.getLikeStatus();
		String email=like.getemail();
		Like likeObj=tweetService.findByTweetIdAndEmail(tweetid,email);
		if(null==likeObj||!(likeObj.getLikeStatus().equals("Like")))
		{
			Boolean result=tweetService.save(like);
			if(result) {
				response="Details registered successfully";
			}
			else {
				response="Details not registered successfully";
			}
		}
		else {
			response="Already liked-";
		}
		return response;
	}
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
				ex.getBindingResult().toString());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}	
	
}
