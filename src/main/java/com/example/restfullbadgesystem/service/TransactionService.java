package com.example.restfullbadgesystem.service;

import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.domain.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface TransactionService {
    Collection<Transaction> findAllByMember(Member member);
    Transaction create(Transaction transaction);
    Page findAll(Pageable pageable);
    Transaction findById(int id);
    void update(Transaction transaction);
    void delete(Transaction transaction);
    Transaction getById(int id);
}
