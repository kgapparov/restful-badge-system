package com.example.restfullbadgesystem.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("unlimited")
public class UnlimitedMembership extends Membership{
    // no extra properties for this field for now
}
