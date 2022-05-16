package com.example.restfullbadgesystem.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "plan")
    private Collection<Membership> memberships;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Collection<Role> allowedRoles;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Collection<LocationType> allowedLocationTypes;

    public Plan(String name, String description, Collection<Membership> memberships,
                Collection<Role> allowedRoles, Collection<LocationType> allowedLocationTypes) {
        this.name = name;
        this.description = description;
        this.memberships = memberships;
        this.allowedRoles = allowedRoles;
        this.allowedLocationTypes = allowedLocationTypes;
    }
}
