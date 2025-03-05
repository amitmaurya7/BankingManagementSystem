package com.banking.accountservice.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	
	private Long userId; // many to one relations
	
	@ManyToOne
	@JoinColumn(name = "branchId")
	private Branches branches;
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	public enum AccountType{
		SAVING,
		CURENT
	}
	 
	private Long balance;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public enum Status{
		ACTIVE,
		INACTIVE,
		CLOSED
	}
	
	private String createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Timestamp(System.currentTimeMillis()));
}
