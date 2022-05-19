package com.example.restfullbadgesystem.service;

import com.example.restfullbadgesystem.configs.RabbitMQConfig;
import com.example.restfullbadgesystem.domain.Transaction;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionQueueConsumerImpl implements TransactionQueueConsumer{
    @Qualifier("transaction")
    @Autowired
    private TransactionService service;

    @Override
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consume(Transaction transaction) {
        service.create(transaction);
    }
}
