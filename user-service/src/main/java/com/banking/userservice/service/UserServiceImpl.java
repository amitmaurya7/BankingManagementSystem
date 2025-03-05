package com.banking.userservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.userservice.entity.Users;
import com.banking.userservice.exceptionhandler.UserNotFoundException;
import com.banking.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService  {
	
	 private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void register(Users user) {
		userRepository.save(user);
		
	}

	@Override
	public String login(String email, String password) {
		Users user = userRepository.findByEmail(email).orElseThrow(()-> new UserNotFoundException("user is not present with email: "+email));
		if(user.getPassword().equals(password)) {
			return "User logged in successfully";
		}
		return "Credential is not valid";
	}

	@Override
	public Users userDetails(Long id) {
		Users user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User is not present with id: "+id));
		return user;
	}

	@Override
	public boolean userExist(Long userId) {
	    Optional<Users> user = userRepository.findById(userId);
		
	    logger.info("User >>>" +user.toString());
		if(user.isPresent()) {
			return true;
		}
		return false;
	}

}
