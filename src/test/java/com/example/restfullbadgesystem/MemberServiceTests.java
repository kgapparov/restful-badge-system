package com.example.restfullbadgesystem;

import com.example.restfullbadgesystem.domain.Badge;
import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.domain.Membership;
import com.example.restfullbadgesystem.domain.Role;
import com.example.restfullbadgesystem.repositories.MemberDAO;
import com.example.restfullbadgesystem.services.MemberService;
import com.example.restfullbadgesystem.services.MemberServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class MemberServiceTests {

    @TestConfiguration
    static class MemberServiceImplTestContextConfiguration {
        @Bean
        public MemberService memberService() {
            return new MemberServiceImpl();
        }
    }

    @Autowired
    private MemberService memberService;

    @MockBean
    private MemberDAO memberDAO;

    private Member member;

    @Before
    public void setUp() {
        Collection<Role> roles = new ArrayList<>();
        roles.add(Role.STUDENT);
        Collection<Membership> memberships = new ArrayList<>();
        Collection<Badge> badges = new ArrayList<>();

        member = new Member("Siddhant", "Pageni", "siddhant_pageni@gmail.com",
                roles, memberships, badges);

        Mockito.when(memberDAO.save(member)).thenReturn(member);
        Mockito.when(memberDAO.findById(1)).thenReturn(Optional.of(member));
    }

    @Test
    public void whenAllDetailsThenMemberShouldBeCreated() {

        Member savedMember = memberService.createMember(member);

        System.out.println(member.toString());
        System.out.println(savedMember.toString());
        Assert.assertEquals(member, savedMember);
    }

    @Test
    public void whenValidIdThenMemberShouldBeFound() {

        Member searchedMember = memberService.getMember(1);

        Assert.assertEquals(member, searchedMember);
    }
}
