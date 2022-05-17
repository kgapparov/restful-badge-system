package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.Badge;
import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.repositories.BadgeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class BadgeServiceImple implements BadgeService {

    @Autowired
    BadgeDAO badgeDAO;

    //for creating new Badge
    public Badge createBadge(Badge badge) {
        return badgeDAO.save(badge);
    }

    //for getting all the Badges
    public List<Badge> getAllBadges() {
        return badgeDAO.findAll();
    }

    //for getting all the Badges by memberId
    public Collection<Badge> getAllBadgesByMember(Member member) {
        return badgeDAO.findAllByMember(member);
    }

    //for getting single badge
    public Badge getBadge(Long id) {
        Badge badgeFound = null;
        if (badgeDAO.findById(id).isPresent()) {
            badgeFound = badgeDAO.findById(id).get();
        }
        return badgeFound;
    }

    public Badge updateBadge(Badge badge) {

        return badgeDAO.save(badge);

    }

    // delete Badge
    public void deleteBadge(Long id) {

        badgeDAO.deleteById(id);
    }

    // Update lost Badge
    public Badge updateLostBadge(Long id) {

        // get the lostbadge by id, Make it inactive and Save it
        Badge lostBadge = badgeDAO.findById(id).get();
        lostBadge.setIsActive(false);
        badgeDAO.save(lostBadge);

        // getting member from lost badge, set a batch to it
        // shift the lost batch ExpireDate to new batch ExpireDate
        Member lostBadgeMemeber = lostBadge.getMember();
        Badge newBadge = new Badge();
        newBadge.setMember(lostBadgeMemeber);
        newBadge.setExpireDate(lostBadge.getExpireDate());
        return badgeDAO.save(newBadge);
    }
}
