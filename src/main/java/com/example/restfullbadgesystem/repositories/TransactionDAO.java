package com.example.restfullbadgesystem.repositories;

import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.domain.Transaction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TransactionDAO extends PagingAndSortingRepository<Transaction, Integer> {
    Collection<Transaction> findAllByMember(Member member);
}
