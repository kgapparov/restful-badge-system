package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.Badge;

import java.util.List;

public interface BadgeService {

    //for creating new Badge
    public Badge createBadge(Badge badge);

    //for getting all the Badges
    public List<Badge> getAllBadges();

    //for getting single badge
    public Badge getBadge(Long id);

    // updating single Badge expirydate  by using id
    public Badge updateBadge(Long id);

    // delete Badge
    public void deleteBadge(Long id);

    public Badge replaceBadge(Long id);

}
