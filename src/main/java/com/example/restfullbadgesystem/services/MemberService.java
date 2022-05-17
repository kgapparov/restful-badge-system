package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.Badge;
import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.domain.Membership;
import com.example.restfullbadgesystem.domain.Role;

import java.util.Collection;

public interface MemberService {
    public Member createMember(Member member);
    public Member getMember(int id);
    public Member updateMember(Member member);
    public Collection<Badge> getBadgesForMember(int id);
}
