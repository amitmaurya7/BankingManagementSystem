package transactionservicetest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import com.banking.transactionservice.entity.Transactions;
import com.banking.transactionservice.entity.Transactions.TxnStatus;
import com.banking.transactionservice.entity.Transactions.TxnType;
import com.banking.transactionservice.repository.TransactionRepository;
import com.banking.transactionservice.service.TransactionServiceImpl;
import com.banking.transactionservice.servicecommunication.AccountClient;
import com.banking.transactionservice.transactiondto.BalanceUpdateDto;

import model.NotificationEvent;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {


	@InjectMocks
	private TransactionServiceImpl transactionServiceImpl;

	@Mock
	private TransactionRepository transactionRepository;
	
	@Mock
	private BalanceUpdateDto balanceUpdateDto;
	
	
	@Mock
	private AccountClient accountClient;
	
	@Mock
	private KafkaTemplate<String, NotificationEvent> kafkaTemplate;
	
	@Test
	public void transactionTest() {
		Transactions transactions = new Transactions();
		transactions.setAccountId(1L);
		transactions.setToAccountId(1L);
		transactions.setAmount(1000L);
		transactions.setTxnType(TxnType.DEPOSIT);
		transactions.setTxnStatus(TxnStatus.SUCCESS);
		
		when(accountClient.updateBalance(any(BalanceUpdateDto.class))).thenReturn("Updated");
		
		String result = transactionServiceImpl.transaction(transactions);
		
		assertNotNull(result);
	}

	
}
