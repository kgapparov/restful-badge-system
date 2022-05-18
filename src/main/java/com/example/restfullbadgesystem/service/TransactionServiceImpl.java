package com.example.restfullbadgesystem.service;

import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.domain.Transaction;
import com.example.restfullbadgesystem.repositories.TransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{

    private TransactionDAO repository;

    @Autowired
    public void setRepository(TransactionDAO repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Transaction> findAllByMember(Member member) {
        return repository.findAllByMember(member);
    }

    @Override
    public void create(Transaction transaction) {
        repository.save(transaction);
    }

    @Override
    public void update(Transaction transaction) {
        repository.save(transaction);
    }

    @Override
    public void delete(Transaction transaction) {
        repository.delete(transaction);
    }

    @Override
    public Transaction getById(int id) {
        return repository.findById(id).get();
    }
}
