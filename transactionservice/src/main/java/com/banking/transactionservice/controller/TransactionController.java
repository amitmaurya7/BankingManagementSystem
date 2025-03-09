package com.banking.transactionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.transactionservice.entity.Transactions;
import com.banking.transactionservice.service.TransactionService;

@RestController
@RequestMapping("/transactions/")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/amountTransfer")
	public ResponseEntity<String> transaction(@RequestBody Transactions transactions){
		transactionService.transaction(transactions);
		return new ResponseEntity<>("Balance Updated successfully", HttpStatus.OK);
	}
	
	@GetMapping("/history")
	public ResponseEntity<List<Transactions>> getAllTransactions(){
		List<Transactions> transactions = transactionService.transactions();
		return new ResponseEntity<List<Transactions>>(transactions, HttpStatus.OK);
	}
}
