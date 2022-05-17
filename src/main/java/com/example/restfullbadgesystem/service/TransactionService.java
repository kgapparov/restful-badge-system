package com.example.restfullbadgesystem.service;

import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.domain.Transaction;

import java.util.Collection;

public interface TransactionService {
    Collection<Transaction> findAllByMember(Member member);
    void create(Transaction transaction);
    void update(Transaction transaction);
    void delete(Transaction transaction);
    Transaction getById(int id);
}
