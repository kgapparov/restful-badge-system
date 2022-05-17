package com.example.restfullbadgesystem.controllers;

import com.example.restfullbadgesystem.domain.Badge;
import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Member createMember(@RequestBody Member member){
        return memberService.createMember(member);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable int id, @RequestBody Member member) {
        return memberService.updateMember(member);
    }

    @GetMapping("{id}/badges")
    public Collection<Badge> getBadgesByMember(@PathVariable int id) {
        return memberService.getBadgesForMember(id);
    }
}
