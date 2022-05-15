package com.example.restfullbadgesystem.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String emailAddress;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Collection<Role> roles;

    @OneToMany(mappedBy = "member")
    private Collection<Membership> memberships;

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private Collection<Badge> badges;
}
