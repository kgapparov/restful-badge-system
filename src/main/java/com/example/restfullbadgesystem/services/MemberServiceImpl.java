package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.*;
import com.example.restfullbadgesystem.repositories.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
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

    // TODO: uncomment this after Transaction Service class is created
    // @Autowired
    // private TransactionService transactionService;

    public Member createMember(Member member) {
        System.out.println("Inside Create Member");
        System.out.println(member.toString());
        Member result = memberDAO.save(member);
        System.out.println(result);
        return memberDAO.save(member);
    }

    public Member getMember(int id) {
        Optional<Member> memberOptional = memberDAO.findById(id);
        return memberOptional.orElse(null);
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
        // TODO: Invoke Transaction Service method to get the collection once the method is created.
        // return transactionService.getAllTransactionByMember(getMember(id));
        return null;
    }

}
