package com.banking.accountservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Branches")
public class Branches {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long branchId;
	
	private String branchName;
	private String ifscCode;
	private String location;
}
