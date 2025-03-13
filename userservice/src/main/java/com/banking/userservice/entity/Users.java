package com.banking.userservice.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "userDetails")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
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
