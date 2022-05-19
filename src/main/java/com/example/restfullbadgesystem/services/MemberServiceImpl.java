package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.*;
import com.example.restfullbadgesystem.repositories.MemberDAO;
import com.example.restfullbadgesystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    private BadgeService badgeService;

    @Autowired
    private PlanService planService;

    @Autowired
    private MembershipService membershipService;

    @Qualifier("transaction")
    @Autowired
     private TransactionService transactionService;

    public Member createMember(Member member) {
        return memberDAO.save(member);
    }

    public Member getMember(int id) {
        return memberDAO.findById(id).orElse(null);
    }

    public Member updateMember(Member member) {
        return memberDAO.save(member);
    }

    @Override
    public Collection<Badge> getBadgesForMember(int id) {
        return badgeService.getAllBadgesByMember(getMember(id));
    }

    @Override
    public Collection<Plan> getPlansForMember(int id) {
        return getMember(id).getMemberships()
                .stream().map(Membership::getPlan).distinct().toList();
    }

    @Override
    public Collection<Membership> getMembershipsForMember(int id) {
        return membershipService.getAllMembershipByMember(getMember(id));
    }

    @Override
    public Collection<Transaction> getTransactionsForMember(int id) {
        return transactionService.findAllByMember(getMember(id));
    }

}
