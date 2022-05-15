package com.example.restfullbadgesystem.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate issueDate;
    private LocalDate expireDate;

    private Boolean isActive;

    @ManyToOne
    private Member member;
}
