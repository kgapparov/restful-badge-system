package com.example.restfullbadgesystem.service;

import com.example.restfullbadgesystem.domain.Transaction;

public interface TransactionQueuePublisherService {
    void send(Transaction message);
}

