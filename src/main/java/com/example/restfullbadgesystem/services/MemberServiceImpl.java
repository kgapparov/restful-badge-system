package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.repositories.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDAO memberDAO;

    public Member createMember(Member member) {
        return memberDAO.save(member);
    }

    public Member getMember(int id) {
        System.out.println("Member Service Impl -> getMember -> " + id);
        return memberDAO.findById(id).get();
    }

    public Member updateMember(Member member) {
        return memberDAO.save(member);
    }
}
