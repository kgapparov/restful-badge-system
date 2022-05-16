package com.example.restfullbadgesystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Data
@NoArgsConstructor
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

    public Member(String firstName, String lastName, String emailAddress, Collection<Role> roles,
                  Collection<Membership> memberships, Collection<Badge> badges) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.roles = roles;
        this.memberships = memberships;
        this.badges = badges;
    }

    // Enforced Convenience Methods for Badge
    public boolean addBadge(Badge badge) {
        badge.setMember(this);
        return badges.add(badge);
    }

    public boolean removeBadge(Badge badge) {
        return badges.remove(badge);
    }

    public Collection<Badge> getBadges() {
        return Collections.unmodifiableCollection(badges);
    }

    public void setBadges(Collection<Badge> badges) {
        if(badges != null)
            badges.stream().forEach((badge -> badge.setMember(this))); // make sure that the "member" field is populated properly
        this.badges = badges;
    }

    // Enforced Convenience Methods for Membership
    public boolean addMembership(Membership membership) {
        membership.setMember(this);
        return memberships.add(membership);
    }

    public boolean removeMembership(Membership membership) {
        return memberships.remove(membership);
    }

    public Collection<Membership> getMemberships() {
        return Collections.unmodifiableCollection(memberships);
    }

    public void setMemberships(Collection<Membership> memberships) {
        if(memberships != null)
            memberships.stream().forEach((membership -> membership.setMember(this))); // make sure that the "member" field is populated properly
        this.memberships = memberships;
    }
}
