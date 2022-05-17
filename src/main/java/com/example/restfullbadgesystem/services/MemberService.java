package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.*;

import java.util.Collection;

public interface MemberService {
    public Member createMember(Member member);
    public Member getMember(int id);
    public Member updateMember(Member member);
    public Collection<Badge> getBadgesForMember(int id);
    public Collection<Plan> getPlansForMember(int id);
    public Collection<Membership> getMembershipsForMember(int id);
    public Collection<Transaction> getTransactionsForMember(int id);
}
