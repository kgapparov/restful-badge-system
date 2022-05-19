package com.example.restfullbadgesystem.service;

import com.example.restfullbadgesystem.domain.Transaction;

public interface TransactionQueueConsumer {
    void consume(Transaction transaction);
}
