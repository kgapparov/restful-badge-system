package com.example.restfullbadgesystem.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
@DiscriminatorValue("checker")
@NoArgsConstructor
public class CheckerMembership extends Membership{
    // No extra property for now

    public CheckerMembership(LocalDate startDate, LocalDate endDate, Member member, Plan plan) {
        super(startDate, endDate, member, plan);
    }
}
