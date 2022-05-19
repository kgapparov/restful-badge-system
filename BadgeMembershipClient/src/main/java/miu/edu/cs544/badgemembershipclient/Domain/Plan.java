package miu.edu.cs544.badgemembershipclient.Domain;

import lombok.Data;

import java.util.Collection;

@Data
public class Plan {
    private int id;

    private String name;
    private String description;

    private Collection<Membership> memberships;

    private Collection<Role> allowedRoles;

    private Collection<LocationType> allowedLocationTypes;
}
