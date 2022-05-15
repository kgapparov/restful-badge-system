package com.example.restfullbadgesystem.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "plan")
    private Collection<Membership> memberships;

    @Enumerated
    @ElementCollection
    private Collection<Role> allowedRoles;

    @Enumerated
    @ElementCollection
    private Collection<LocationType> allowedLocationTypes;
}
