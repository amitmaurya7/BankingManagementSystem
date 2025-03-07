package com.banking.accountservice.dto;

import lombok.Data;

@Data
public class UpdateBalanceDto {

	private Long accountId;
	private Long balance;
	private String action;
}
