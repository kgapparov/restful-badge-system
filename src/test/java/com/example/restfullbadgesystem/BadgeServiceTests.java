package com.example.restfullbadgesystem;

import com.example.restfullbadgesystem.domain.Badge;
import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.domain.Membership;
import com.example.restfullbadgesystem.domain.Role;
import com.example.restfullbadgesystem.repositories.BadgeDAO;
import com.example.restfullbadgesystem.services.BadgeService;
import com.example.restfullbadgesystem.services.BadgeServiceImple;
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
public class BadgeServiceTests {


    @TestConfiguration
    static class BadgeServiceImplTestContextConfiguration {
        @Bean
        public BadgeService badgeService() {
            return new BadgeServiceImple();
        }
    }

    @Autowired
    private BadgeService badgeService;

    @MockBean
    private BadgeDAO badgeDAO;

    private Badge badge;
    Member member;
    Collection<Badge>  badges;
    @Before
    public void setUp() {

        Collection<Role> roles = new ArrayList<>();
        roles.add(Role.STUDENT);
        Collection<Membership> memberships = new ArrayList<>();
        badges = new ArrayList<>();

        member = new Member("Dawit", "Zeleke", "dave123@gmail.com",
                roles, memberships, badges);
        badge = new Badge(member);

        System.out.println("Setup");
        System.out.println(badge.toString());
        Mockito.when(badgeDAO.save(badge)).thenReturn(badge);
        Mockito.when(badgeDAO.findById(0)).thenReturn(Optional.of(badge));
        Mockito.when(badgeDAO.findAllByMember(member)).thenReturn(badges);
    }

    @Test
    public void whenValidIdThenBadgeShouldBeFound() {
        System.out.println("shouting badge value: " + badge);
        Badge searchedBadge = badgeService.getBadge(0);
        System.out.println("Test Function -> Search");
        System.out.println(searchedBadge.toString());
        Assert.assertEquals(searchedBadge, badge);
    }

    @Test
    public void whenAllDetailsThenBadgeShouldBeCreated() {
        Badge savedBadeg = badgeService.createBadge(badge);
        System.out.println(badge.toString());
        System.out.println(savedBadeg.toString());
        Assert.assertEquals(badge, savedBadeg);
    }

    @Test
    public void findAllByMemberTest() {
        Collection<Badge> findedBadgs = badgeDAO.findAllByMember(member);
        Assert.assertEquals(badges, findedBadgs);
    }
}

