package com.example.restfullbadgesystem.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
// using Single Table strategy because the subclasses don't have too many properties
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "membershipType", discriminatorType = DiscriminatorType.STRING)
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Plan plan;
}
