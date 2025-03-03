package com.banking.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.userservice.dto.LoginDto;
import com.banking.userservice.entity.Users;
import com.banking.userservice.service.UserService;

@RestController
@RequestMapping("/users/")
public class Controller {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> userRegister(@RequestBody Users user) {
		userService.register(user);
		return new ResponseEntity<>("User Register Successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Users> userDetails(@PathVariable Long userId){
		Users user = userService.userDetails(userId);
		return new ResponseEntity<>(user, HttpStatus.FOUND);
	}

	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@RequestBody LoginDto loginDto){
		String message = userService.login(loginDto.getEmail(), loginDto.getPassword());
		return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
	}
}
