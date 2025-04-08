package com.banking.reportingservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.reportingservice.dto.StatementDto;
import com.banking.reportingservice.entity.Statement;
import com.banking.reportingservice.servicecommunication.TransactionClient;

import model.TransDto;

@Service
public class ReportingServiceImpl implements ReportingService {

	@Autowired
	private TransactionClient transactionClient;

	@Override
	public List<TransDto> getTransactions(StatementDto statement) {
		List<TransDto> transactions = transactionClient.getAllTransactions();
		System.out.println("statement "+statement.toString());
//		List<TransDto> trans = transactions.stream().filter(t-> t.getAccountId() == statement.getAccountId()).filter(t-> LocalDateTime.parse(t.getTxnDate()).isBefore(statement.getStartDateTime()) && !LocalDateTime.parse(t.getTxnDate()).isAfter(statement.getEndDateTime())).collect(Collectors.toList());
		return transactions;
	}

}
