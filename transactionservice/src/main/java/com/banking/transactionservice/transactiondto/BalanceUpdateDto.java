package com.banking.transactionservice.transactiondto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class BalanceUpdateDto {

	private Long accountId;
	private Long balance;
	private String action;
}
