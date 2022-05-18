package com.example.restfullbadgesystem.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime dateTime;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Location location;

    @Enumerated(EnumType.STRING)
    private TransactionType type;
}
