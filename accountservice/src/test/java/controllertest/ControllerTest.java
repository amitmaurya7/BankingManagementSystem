package controllertest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.banking.accountservice.controller.AccountController;
import com.banking.accountservice.dto.UpdateBalanceDto;
import com.banking.accountservice.entity.Accounts;
import com.banking.accountservice.entity.Branches;
import com.banking.accountservice.entity.Accounts.AccountType;
import com.banking.accountservice.entity.Accounts.Status;
import com.banking.accountservice.service.AccountService;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

	@InjectMocks
	private AccountController accountController;
	
	@Mock
	private AccountService accountService;
	
	
	@Test
	public void crateAccountTest() {
		Branches branch = new Branches(1L, "sbi nagavara", "sbin011510", "South bangalore");
		Accounts accounts = new Accounts(1L, 1L, branch, AccountType.SAVING, 1000L, Status.ACTIVE, "2025-03-19 11:59:30");
		
		ResponseEntity<String> response = accountController.createAccount(accounts);
		assertNotNull(response);
	}
	
	@Test
	public void createBranchTest() {
		Branches branch = new Branches(1L, "sbi nagavara", "sbin011510", "South bangalore");
		Accounts accounts = new Accounts(1L, 1L, branch, AccountType.SAVING, 1000L, Status.ACTIVE, "2025-03-19 11:59:30");
		
		ResponseEntity<String> response = accountController.createBranch(branch);
		
		assertNotNull(response);
	}
	
	@Test
	public void updateBalanceTest() {
		UpdateBalanceDto updateBalanceDto = new UpdateBalanceDto(1L, 1000L, "deposit");
		
		ResponseEntity<String> response = accountController.updateBalance(updateBalanceDto);
		
		assertNotNull(response);
	}
	
	
	
	
	
}
