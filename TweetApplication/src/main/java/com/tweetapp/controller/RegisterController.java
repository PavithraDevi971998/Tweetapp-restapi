package com.tweetapp.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.tweetapp.domain.ExceptionResponse;
import com.tweetapp.domain.Register;
import com.tweetapp.service.RegisterService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHome() {
		return "Welcome to TweetApp";
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String getUserDetails(@Valid @RequestBody Register register) {
		String response;
		String pwd = register.getPassword();
		String cpwd = register.getConfirmpwd();
		String email = register.getEmail();
		Register result1=registerService.findByEmail(email);
		if (pwd.equals(cpwd)) {
			if(null==result1||!(result1.getEmail().equals(email))) {
				Boolean result = registerService.save(register);
				if (result) {
					response = "Details registered successfully";
				} else {
					response = "Details not registered successfully";
				}
		} 
			else{
				response = "Details already present..Try with new email";}
		}
			else {
			
			response = "password and confirm password is not same";
		}
		return response;

	}

	@PostMapping(path = "/tweetapp/login")
	public String logincheckdemo(@RequestBody Register register) {
		String response;
		String username = register.getFirstName();
		String password = register.getPassword();
		Boolean result = registerService.findByFirstNameAndPassword(username, password);
		if (result) {
			response = "Logged in  successfully";
		} else {
			response = "Incorrect username and password";
		}
		return response;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<Register> getUsers() {
		return registerService.findAll();
	}

	@RequestMapping(value = "/users/all/{firstname}", method = RequestMethod.GET)
	public List<Register> getSpecificUsers(@PathVariable String firstname) {
		return registerService.findByFirstName(firstname);
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
				ex.getBindingResult().toString());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}