package com.example.restfullbadgesystem.controllers;

import com.example.restfullbadgesystem.domain.Badge;
import com.example.restfullbadgesystem.services.BadgeServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/badges")
public class BadgeController {

    @Autowired
    private BadgeServiceImple badgeServiceImple;

    @GetMapping
    public List<Badge> getAllBadges() {
        return badgeServiceImple.getAllBadges();
    }

    @GetMapping("/{id}")
    public Badge getBadge(Long id) {
        return badgeServiceImple.getBadge(id);
    }

    @PostMapping("/")
    public Badge createBadge(@RequestBody Badge badge) {
        return badgeServiceImple.createBadge(badge);
    }

    // update the Expired Badge
    @PatchMapping("/{id}")
    public Badge updateBadge(@PathVariable Long id) {
        return badgeServiceImple.updateBadge(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBadge(@PathVariable Long id) {
        badgeServiceImple.deleteBadge(id);
    }

    @PostMapping("/replace/{id}")
    public Badge replaceBadge(@PathVariable Long id) {
        return badgeServiceImple.replaceBadge(id);
    }

}
