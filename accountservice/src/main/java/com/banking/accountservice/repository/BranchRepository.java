package com.banking.accountservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.accountservice.entity.Branches;

@Repository
public interface BranchRepository extends JpaRepository<Branches, Long> {

	Optional<Branches> getBranchesByBranchId(Long branchId);
}
