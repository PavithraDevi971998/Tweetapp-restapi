package com.tweetapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.dao.RegisterDao;
import com.tweetapp.domain.Register;
@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	RegisterDao registerDao;
	@Override
	public Boolean save(Register register) {
		// TODO Auto-generated method stub
		Boolean response;
		Register result=registerDao.save(register);
		if(null!=result)
		{
			response=true;
		}
		else {
			response=false;
		}
		return response ;
	}
	@Override
	public Boolean findByFirstNameAndPassword(String username, String password) {
		Boolean response;
		Register result=registerDao.findByFirstNameAndPassword(username, password);
		if(null!=result)
		{
			response=true;
		}
		else {
			response=false;
		}
		return response ;
	}
	@Override
	public List<Register> findAll() {
		// TODO Auto-generated method stub
		return registerDao.findAll();
	}
	@Override
	public List<Register> findByFirstName(String username) {
		// TODO Auto-generated method stub
		return registerDao.findByFirstName(username);
	}
	@Override
	public Register findByEmail(String email) {
		
		return registerDao.findByEmail(email);
	}

}
