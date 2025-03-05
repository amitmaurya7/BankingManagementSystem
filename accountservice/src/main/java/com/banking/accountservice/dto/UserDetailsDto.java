package com.banking.accountservice.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UserDetailsDto {

	Long userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String password;
	private Date dob;
	private String address;
	
	@Enumerated(EnumType.STRING) 
	private KYCStatus kycStatus;

	    public enum KYCStatus {
	        PENDING,
	        VERIFIED,
	        REJECTED
	    }
	    
	private String createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Timestamp(System.currentTimeMillis()));
}
