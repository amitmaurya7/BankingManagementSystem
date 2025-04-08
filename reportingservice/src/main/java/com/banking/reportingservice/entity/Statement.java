package com.banking.reportingservice.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "statement")
@NoArgsConstructor
@AllArgsConstructor
public class Statement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long statementId;
	
	private Long accountId;
	
	private LocalDate startDateTime;
	
	private LocalDate endDateTime;
	
	private String generatedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Timestamp(System.currentTimeMillis()));
}
