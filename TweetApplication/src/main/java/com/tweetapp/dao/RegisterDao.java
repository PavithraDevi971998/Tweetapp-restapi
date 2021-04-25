package com.tweetapp.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.domain.Register;
@Repository
public interface RegisterDao extends MongoRepository<Register,Integer> {

	Register save(Register register);
	Register findByFirstNameAndPassword(String username, String password);
	List<Register> findByFirstName(String username);
	Register findByEmail(String email);

}
