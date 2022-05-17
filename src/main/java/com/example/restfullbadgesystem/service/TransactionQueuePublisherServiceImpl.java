package com.example.restfullbadgesystem.service;


import com.example.restfullbadgesystem.domain.Transaction;
import com.example.restfullbadgesystem.configs.RabbitMQConfig;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
@NoArgsConstructor
public class TransactionQueuePublisherServiceImpl implements TransactionQueuePublisherService {

    private RabbitTemplate template;

    @Autowired
    public void setTemplate(RabbitTemplate template) {
        this.template = template;
    }

    @Override
    public void send(Transaction transaction) {
        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, transaction);
    }
}
