package com.example.restfullbadgesystem.service;

import com.example.restfullbadgesystem.domain.Transaction;

public interface TransactionQueuePublisher{
    void send(Transaction message);
}

