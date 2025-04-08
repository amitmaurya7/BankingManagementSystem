package com.banking.reportingservice.dto;

import lombok.Data;

@Data
public class StatementDto {

	private Long accountId;
	private String startDateTime;
	private String endDateTime;
}
