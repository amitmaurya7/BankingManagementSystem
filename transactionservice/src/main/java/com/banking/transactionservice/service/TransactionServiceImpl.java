package com.banking.transactionservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.banking.transactionservice.entity.Transactions;
import com.banking.transactionservice.repository.TransactionRepository;
import com.banking.transactionservice.servicecommunication.AccountClient;
import com.banking.transactionservice.transactiondto.BalanceUpdateDto;
import com.banking.transactionservice.transactiondto.NotificationEvent;
import com.banking.transactionservice.transactiondto.NotificationEvent.NotificationType;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private AccountClient accountClient;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private BalanceUpdateDto balanceUpdateDto;
	
	@Autowired
	private KafkaTemplate<String, NotificationEvent> kafkaTemplate;
	
	@Override
	public String transaction(Transactions transactions) {
		String message = "";
		if(transactions.getAccountId() == transactions.getToAccountId()) {
			balanceUpdateDto.setAccountId(transactions.getAccountId());
			balanceUpdateDto.setBalance(transactions.getAmount());
			balanceUpdateDto.setAction(transactions.getTxnType().toString());
			message =  accountClient.updateBalance(balanceUpdateDto);
		}else {
			balanceUpdateDto.setAccountId(transactions.getAccountId());
			balanceUpdateDto.setBalance(transactions.getAmount());
			balanceUpdateDto.setAction("withdraw");
			message =  accountClient.updateBalance(balanceUpdateDto);
			
			balanceUpdateDto.setAccountId(transactions.getToAccountId());
			balanceUpdateDto.setBalance(transactions.getAmount());
			balanceUpdateDto.setAction("deposit");
			message =  accountClient.updateBalance(balanceUpdateDto);
		}
		transactionRepository.save(transactions);
		 NotificationEvent event = new NotificationEvent(
	                transactions.getAccountId(),
	                "Your account was debited with $" + transactions.getAmount(),
	                NotificationType.EMAIL
	        );
	        kafkaTemplate.send("notification-topic", event);
		
		return message;
	}

	@Override
	public List<Transactions> transactions() {
		return transactionRepository.findAll();
	}

}
