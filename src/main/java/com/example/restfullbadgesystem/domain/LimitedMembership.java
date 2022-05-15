package com.example.restfullbadgesystem.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("limited")
public class LimitedMembership extends Membership{
    private int limit;
}
