package com.banking.accountservice.service;

import com.banking.accountservice.entity.Accounts;
import com.banking.accountservice.entity.Branches;

public interface AccountService {

	public void createAccount(Accounts account);
	public void createBranch(Branches branch);
	public Accounts getAccountById(Long accountId);
}
