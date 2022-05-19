package com.example.restfullbadgesystem.service;

import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.domain.Transaction;
import com.example.restfullbadgesystem.repositories.TransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service("transaction")
@Transactional
public class TransactionServiceImpl implements TransactionService{

    private TransactionDAO repository;

    @Autowired
    public void setRepository(TransactionDAO repository) {
        this.repository = repository;
    }

    @Override
    public Page findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Transaction findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<Transaction> findAllByMember(Member member) {
        return repository.findAllByMember(member);
    }

    @Override
    public Transaction create(Transaction transaction) {
        return repository.save(transaction);
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
        return repository.findById(id).orElse(null);
    }
}
