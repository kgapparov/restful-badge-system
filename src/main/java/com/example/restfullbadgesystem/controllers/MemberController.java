package com.example.restfullbadgesystem.controllers;

import com.example.restfullbadgesystem.domain.*;
import com.example.restfullbadgesystem.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Collection;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable int id) {
        System.out.println("MemberController -> getMemeberById -> " + id);
        return memberService.getMember(id);
    }

    @PostMapping
    @RolesAllowed({"user", "admin"})
    public Member createMember(@RequestBody Member member){
        return memberService.createMember(member);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable int id, @RequestBody Member member) {
        return memberService.updateMember(member);
    }

    @GetMapping("/{id}/badges")
    public Collection<Badge> getBadgesByMember(@PathVariable int id) {
        return memberService.getBadgesForMember(id);
    }

    @GetMapping("/{id}/plans")
    public Collection<Plan> getPlansByMember(@PathVariable int id) {
        return memberService.getPlansForMember(id);
    }

    @GetMapping("/{id}/memberships")
    public Collection<Membership> getMembershipsByMember(@PathVariable int id) {
        return memberService.getMembershipsForMember(id);
    }

    @GetMapping("/{id}/transactions")
    public Collection<Transaction> getTransactionsByMember(@PathVariable int id) {
        return memberService.getTransactionsForMember(id);
    }
}
