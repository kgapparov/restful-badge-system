package com.example.restfullbadgesystem.controllers;

import com.example.restfullbadgesystem.domain.Badge;
import com.example.restfullbadgesystem.services.BadgeServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.security.RolesAllowed;
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
    @RolesAllowed({"admin", "user"})
    public Badge getBadge(@PathVariable int id) {
        return badgeServiceImple.getBadge(id);
    }

    @PostMapping("/")
    @RolesAllowed("user")
    public Badge createBadge(@RequestBody Badge badge) {
        return badgeServiceImple.createBadge(badge);
    }
    
    @PutMapping("/")
    @RolesAllowed("admin")
    public Badge updateBadge(@RequestBody Badge badge) {
        return badgeServiceImple.updateBadge(badge);
    }

    // Delete badge
    @DeleteMapping("/{id}")
    public void deleteBadge(@PathVariable int id) {
        badgeServiceImple.deleteBadge(id);
    }

    // Update lost Badge
    @PostMapping("/replace/{id}")
    @RolesAllowed("admin")
    public Badge replaceBadge(@PathVariable int id) {
        return badgeServiceImple.updateLostBadge(id);
    }
}
