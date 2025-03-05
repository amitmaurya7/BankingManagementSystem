 package com.banking.accountservice.service;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.accountservice.entity.Accounts;
import com.banking.accountservice.entity.Branches;
import com.banking.accountservice.repository.AccountRepository;
import com.banking.accountservice.repository.BranchRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accoutAccountRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	
	@Override
	public void createAccount(Accounts account) {
		
		accoutAccountRepository.save(account);
		
	}

	@Override
	public void createBranch(Branches branch) {
		branchRepository.save(branch);
		
	}

	@Override
	public Accounts getAccountById(Long accountId) {
		Accounts accounts = null;
		try {
			accounts = accoutAccountRepository.getAccountsByAccountId(accountId).orElseThrow(()-> new AccountNotFoundException());
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		}
		return accounts;
	}
}
