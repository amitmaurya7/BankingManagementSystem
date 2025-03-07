package com.banking.transactionservice.entity;

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
@Table(name = "transactionInfo")
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long txnId;
	
	private Long accountId;
	
	@Enumerated(EnumType.STRING)
	private TxnType txnType;
	
	public  enum TxnType{
		DEPOSIT, 
		WITHDRAW, 
		TRANSFER
	}
	
	private Long amount;
	
	@Enumerated(EnumType.STRING)
	private TxnStatus txnStatus;
	public enum TxnStatus{
		PENDING, 
		SUCCESS, 
		FAILED
	}
	
	private String txnDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Timestamp(System.currentTimeMillis()));
	private Long toAccountId;
}
