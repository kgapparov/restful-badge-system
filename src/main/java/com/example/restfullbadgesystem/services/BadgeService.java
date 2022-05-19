package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.Badge;
import com.example.restfullbadgesystem.domain.Member;

import java.util.Collection;
import java.util.List;

public interface BadgeService {

    //for creating new Badge
    public Badge createBadge(Badge badge);

    //for getting all the Badges
    public List<Badge> getAllBadges();

    //for getting all the Badges
    public Collection<Badge> getAllBadgesByMember(Member member);

    //for getting single badge
    public Badge getBadge(int id);

    // updating expired badge
    public Badge updateBadge(Badge badge);

    // delete Badge
    public void deleteBadge(int id);

    // Update lost Badge
    public Badge updateLostBadge(int id);

}
