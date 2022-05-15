package com.example.restfullbadgesystem.repositories;

import com.example.restfullbadgesystem.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Integer> {
}
