package servicetest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.banking.accountservice.entity.Accounts;
import com.banking.accountservice.entity.Accounts.AccountType;
import com.banking.accountservice.entity.Accounts.Status;
import com.banking.accountservice.entity.Branches;
import com.banking.accountservice.repository.AccountRepository;
import com.banking.accountservice.repository.BranchRepository;
import com.banking.accountservice.service.AccountServiceImpl;
import com.banking.accountservice.servicecommunication.UserClient;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

	@InjectMocks
	private AccountServiceImpl accountServiceImpl;
	
	@Mock
	private AccountRepository accountRepository;
	
	@Mock
	private BranchRepository branchRepository;
	
	@Mock
	private UserClient userClient;
	
	@Test
	public void createBranchTest() {
		
		Branches branch = new Branches(1L, "sbi nagavara", "sbin011510", "South bangalore");
		when(branchRepository.save(branch)).thenReturn(branch);
		accountServiceImpl.createBranch(branch);
	}
	
	@Test
	public void createAccountTest() {
		Branches branch = new Branches(1L, "sbi nagavara", "sbin011510", "South bangalore");
		Accounts accounts = new Accounts(1L, 1L, branch, AccountType.SAVING, 1000L, Status.ACTIVE, "2025-03-19 11:59:30");
		
		
		when(userClient.userExist(1L)).thenReturn(true);
		when( branchRepository.getBranchesByBranchId(1L)).thenReturn(Optional.of(branch));
		when(accountRepository.save(accounts)).thenReturn(accounts);
		
		accountServiceImpl.createAccount(accounts);
	}
	
	@Test
	public void updateBalanceTest() {
		Branches branch = new Branches(1L, "sbi nagavara", "sbin011510", "South bangalore");
		Accounts accounts = new Accounts(1L, 1L, branch, AccountType.SAVING, 1000L, Status.ACTIVE, "2025-03-19 11:59:30");
		
		when(accountRepository.getAccountsByAccountId(1L)).thenReturn(Optional.of(accounts));
		
		String response = accountServiceImpl.updateBalance(1L, 1000L, "deposit");
		
		assertNotNull(response);
	}
	
	
	
	
	
	
	
	
	
	
	
}
