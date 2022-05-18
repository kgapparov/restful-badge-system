package com.example.restfullbadgesystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
// using Single Table strategy because the subclasses don't have too many properties
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "membershipType", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JsonIgnoreProperties("memberships")
    private Member member;

    @ManyToOne
    @JsonIgnoreProperties("memberships")
    private Plan plan;

    public Membership(LocalDate startDate, LocalDate endDate, Member member, Plan plan) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.member = member;
        this.plan = plan;
    }
}
