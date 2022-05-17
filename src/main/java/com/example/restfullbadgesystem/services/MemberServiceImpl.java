package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.Badge;
import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.domain.Membership;
import com.example.restfullbadgesystem.repositories.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    private BadgeService badgeService;

    public Member createMember(Member member) {
        System.out.println("Inside Create Member");
        System.out.println(member.toString());
        Member result = memberDAO.save(member);
        System.out.println(result);
        return memberDAO.save(member);
    }

    public Member getMember(int id) {
        System.out.println("Member Service Impl -> getMember -> " + id);
        return memberDAO.findById(id).get();
    }

    public Member updateMember(Member member) {
        return memberDAO.save(member);
    }

    @Override
    public Collection<Badge> getBadgesForMember(int id) {
        return badgeService.getAllBadgesByMember(getMember(id));
    }
}
