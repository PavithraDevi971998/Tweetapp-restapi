package com.tweetapp.service;

import java.util.List;

import com.tweetapp.domain.Register;

public interface RegisterService {

	Boolean save(Register register);

	Boolean findByFirstNameAndPassword(String username, String password);

	List<Register> findAll();

	List<Register> findByFirstName(String username);

	Register findByEmail(String email);

}
