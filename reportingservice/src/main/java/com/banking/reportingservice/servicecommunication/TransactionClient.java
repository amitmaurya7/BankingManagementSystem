package com.banking.reportingservice.servicecommunication;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import model.TransDto;

@FeignClient(name = "transaction-service", url = "http://localhost:8084/transactions/")
public interface TransactionClient {

	@GetMapping("/history")
	public List<TransDto>getAllTransactions();
}
