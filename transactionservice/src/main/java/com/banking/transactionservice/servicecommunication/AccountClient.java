package com.banking.transactionservice.servicecommunication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.banking.transactionservice.transactiondto.BalanceUpdateDto;


@FeignClient(name = "account-service", url = "http://localhost:8083/accounts/")
public interface AccountClient {

	@PutMapping("/updateBalance")
	public String updateBalance(@RequestBody BalanceUpdateDto balanceUpdateDto);
}
