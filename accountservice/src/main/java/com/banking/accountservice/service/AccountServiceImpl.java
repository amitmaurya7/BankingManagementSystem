 package com.banking.accountservice.service;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.accountservice.dto.AccountResponseDto;
import com.banking.accountservice.dto.UserDetailsDto;
import com.banking.accountservice.entity.Accounts;
import com.banking.accountservice.entity.Branches;
import com.banking.accountservice.exceptionhadler.BranchNotFoundException;
import com.banking.accountservice.exceptionhadler.UserNotFoundException;
import com.banking.accountservice.repository.AccountRepository;
import com.banking.accountservice.repository.BranchRepository;
import com.banking.accountservice.servicecommunication.UserClient;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private UserClient userClient;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	
	@Override
	public void createAccount(Accounts account) {
		
		Long userId = account.getUserId();
		boolean isUserPresent = userClient.userExist(userId);
		if(!isUserPresent) {
			throw new UserNotFoundException("user with id: " + userId+" is not present");
		}
           Long branchId = account.getBranches().getBranchId();
           Branches branches = branchRepository.getBranchesByBranchId(branchId).orElseThrow(()-> new BranchNotFoundException("Branch with id: "+branchId+" is not present"));
           if(branches != null && isUserPresent) {
        	   accountRepository.save(account);
           }
	}

	@Override
	public void createBranch(Branches branch) {
		branchRepository.save(branch);
		
	}

	@Override
	public AccountResponseDto getAccountById(Long accountId){
		Accounts accounts = null;
		try {
			accounts = accountRepository.getAccountsByAccountId(accountId).orElseThrow(()-> new AccountNotFoundException());
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long userId = accounts.getUserId();
		boolean isUserPresent = userClient.userExist(userId);
		if(!isUserPresent) {
			throw new UserNotFoundException("user with id: " + userId+" is not present");
		}
		UserDetailsDto userDetailsDto = userClient.userDetails(userId);
		
		return new AccountResponseDto(userDetailsDto,accounts);
	}

	@Override
	public String updateBalance(Long accountId, Long amount, String action) {
		Accounts accounts = null;
		try {
			accounts = accountRepository.getAccountsByAccountId(accountId).orElseThrow(()-> new AccountNotFoundException());
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		}
		if(action.equalsIgnoreCase("deposit")) {
			Long balance = accounts.getBalance() + amount;
			accounts.setBalance(balance);
			accountRepository.save(accounts);
		}else if(action.equalsIgnoreCase("withdraw")) {
			Long balance = accounts.getBalance() - amount;
			accounts.setBalance(balance);
			accountRepository.save(accounts);
		}
		return "Amount "+action+" successfully";
	}
}
