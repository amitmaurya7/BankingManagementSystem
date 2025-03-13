package com.banking.userservice.service;

import com.banking.userservice.entity.Users;

public interface UserService {

	public void register(Users user);
	
	public String login(String email, String password);
	
	public Users userDetails(Long id);
	
	public boolean userExist(Long userId);
	
}
