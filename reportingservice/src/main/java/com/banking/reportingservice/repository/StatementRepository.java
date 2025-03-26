package com.banking.reportingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.reportingservice.entity.Statement;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Long> {

	
}
