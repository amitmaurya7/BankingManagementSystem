package com.banking.transactionservice.transactiondto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class BalanceUpdateDto {

	private Long accountId;
	private Long balance;
	private String action;
}
