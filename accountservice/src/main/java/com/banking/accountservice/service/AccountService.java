package com.banking.accountservice.service;

import com.banking.accountservice.dto.AccountResponseDto;
import com.banking.accountservice.entity.Accounts;
import com.banking.accountservice.entity.Branches;

public interface AccountService {

	public void createAccount(Accounts account);
	public void createBranch(Branches branch);
	public AccountResponseDto getAccountById(Long accountId);
	public String updateBalance(Long accountId, Long amount, String action);
}
