package com.banking.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.accountservice.entity.Accounts;
import com.banking.accountservice.entity.Branches;
import com.banking.accountservice.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/")
	public ResponseEntity<String> createAccount(@RequestBody Accounts account){
		accountService.createAccount(account);
		return new ResponseEntity<>("Account creaed Successfully", HttpStatus.CREATED);
	}
	
	@PostMapping("/branch")
	public ResponseEntity<String> createBranch(@RequestBody Branches branch){
		accountService.createBranch(branch);
		return new ResponseEntity<>("branch created successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/{accountId}")
	public ResponseEntity<Accounts> getAccountById(@PathVariable Long accountId){
		Accounts accounts = accountService.getAccountById(accountId);
		return new ResponseEntity<>(accounts, HttpStatus.ACCEPTED);
	}
}
