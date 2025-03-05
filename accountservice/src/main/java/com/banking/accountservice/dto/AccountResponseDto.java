package com.banking.accountservice.dto;

import com.banking.accountservice.entity.Accounts;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountResponseDto {

	

	private UserDetailsDto userDetailsDto;
	private Accounts accounts;
    
}
