package miu.edu.cs544.badgemembershipclient.Domain;

import lombok.Data;

import java.util.Collection;

@Data
public class Member {
    private int id;

    private String firstName;
    private String lastName;
    private String emailAddress;

    private Collection<Role> roles;

    private Collection<Membership> memberships;

    private Collection<Badge> badges;
}
