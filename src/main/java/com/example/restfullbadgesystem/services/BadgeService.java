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

    // updating expired badge
    public Badge patchBadge(Long id);

    // delete Badge
    public void deleteBadge(Long id);

    // Update lost Badge
    public Badge updateLostBadge(Long id);

}
