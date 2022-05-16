package com.example.restfullbadgesystem.controllers;

import com.example.restfullbadgesystem.domain.LimitedMembership;
import com.example.restfullbadgesystem.domain.Membership;
import com.example.restfullbadgesystem.domain.UnlimitedMembership;
import com.example.restfullbadgesystem.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/memberships")
public class MembershipController {
    @Autowired
    MembershipService membershipService;

    @PostMapping("/limited")
    public LimitedMembership createLimitedMembership(
            @RequestBody LimitedMembership limitedMembership) {
        return membershipService.createLimitedMembership(limitedMembership);
    }

    @PostMapping("/unlimited")
    public UnlimitedMembership createUnlimitedMembership(
            @RequestBody UnlimitedMembership unlimitedMembership) {
        return membershipService.createUnlimitedMembership(unlimitedMembership);
    }

    @GetMapping("/{id}")
    public <T extends Membership> T getMembershipById(@PathVariable int id) {
        return membershipService.getMembership(id);
    }

    @PutMapping("/{id}")
    public <T extends Membership> T updateMembership(@PathVariable int id, @RequestBody T membership) {
        return membershipService.updateMembership(membership);
    }
}
