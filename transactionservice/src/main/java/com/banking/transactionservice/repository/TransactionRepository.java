package com.banking.transactionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.transactionservice.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long>{

}
