package transactioncontrollertest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.banking.transactionservice.controller.TransactionController;
import com.banking.transactionservice.entity.Transactions;
import com.banking.transactionservice.entity.Transactions.TxnStatus;
import com.banking.transactionservice.entity.Transactions.TxnType;
import com.banking.transactionservice.service.TransactionService;

@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {

	@InjectMocks
	private TransactionController transactionController;
	
	@Mock
	private TransactionService transactionService;
	
	@Test
	public void transactionTest() {
		Transactions transactions = new Transactions();
		transactions.setAccountId(1L);
		transactions.setToAccountId(1L);
		transactions.setAmount(1000L);
		transactions.setTxnType(TxnType.DEPOSIT);
		transactions.setTxnStatus(TxnStatus.SUCCESS);
		
		ResponseEntity<String> response = transactionController.transaction(transactions);
		
		assertNotNull(response);
	}
}
