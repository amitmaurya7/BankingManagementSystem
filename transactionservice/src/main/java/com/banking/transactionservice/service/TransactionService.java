package com.banking.transactionservice.service;

import java.util.List;

import com.banking.transactionservice.entity.Transactions;

public interface TransactionService {

	public String transaction(Transactions transactions);
	public List<Transactions> transactions();
}
