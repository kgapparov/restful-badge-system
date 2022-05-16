package com.example.restfullbadgesystem.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("limited")
@Data
@NoArgsConstructor
public class LimitedMembership extends Membership{
    @Column(name = "membership_limit") // "limit" is a database keyword
    private int limit;

    public LimitedMembership(LocalDate startDate, LocalDate endDate, Member member, Plan plan, int limit) {
        super(startDate, endDate, member, plan);
        this.limit = limit;
    }
}
