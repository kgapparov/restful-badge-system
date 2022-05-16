package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.Badge;
import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.domain.Role;
import com.example.restfullbadgesystem.repositories.BadgeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
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

    //for getting single badge
    public Badge getBadge(Long id) {
        Badge badgeFound = null;
        if (badgeDAO.findById(id).isPresent()) {
            badgeFound = badgeDAO.findById(id).get();
        }
        return badgeFound;
    }

    // updating single Badge expirydate  by using id
    public Badge updateBadge(Long id) {

        Badge foundBadge = badgeDAO.findById(id).get();

        Collection<Role> role = foundBadge.getMember().getRoles();

        LocalDate foundBadgeExpriyDate = foundBadge.getExpireDate();

        if (role.contains("STAFF")) {
            foundBadgeExpriyDate.plusMonths(12);
        } else if (role.contains("FACULTY")) {
            foundBadgeExpriyDate.plusMonths(6);
        } else {
            foundBadgeExpriyDate.plusMonths(1);
        }

        foundBadge.setExpireDate(foundBadgeExpriyDate);

        badgeDAO.save(foundBadge);

        return foundBadge;

    }

    // delete Badge
    public void deleteBadge(Long id) {

        badgeDAO.deleteById(id);
    }

    // replace  lost Badge
    public Badge replaceBadge(Long id) {

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
