package com.example.restfullbadgesystem.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
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

    public Transaction(LocalDateTime dateTime, Member member, Location location, TransactionType type) {
        this.dateTime = dateTime;
        this.member = member;
        this.location = location;
        this.type = type;
    }
}
