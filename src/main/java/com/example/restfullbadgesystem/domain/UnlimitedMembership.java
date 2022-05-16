package com.example.restfullbadgesystem.domain;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("unlimited")
@NoArgsConstructor
public class UnlimitedMembership extends Membership{
    // no extra properties for this field for now

    public UnlimitedMembership(LocalDate startDate, LocalDate endDate, Member member, Plan plan) {
        super(startDate, endDate, member, plan);
    }
}
