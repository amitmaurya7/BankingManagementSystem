package com.banking.accountservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.accountservice.entity.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long> {

	Optional<Accounts> getAccountsByAccountId(Long accountId);
}
