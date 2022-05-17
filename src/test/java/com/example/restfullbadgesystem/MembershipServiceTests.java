package com.example.restfullbadgesystem;

import com.example.restfullbadgesystem.domain.LimitedMembership;
import com.example.restfullbadgesystem.domain.Membership;
import com.example.restfullbadgesystem.repositories.MembershipDAO;
import com.example.restfullbadgesystem.services.MembershipService;
import com.example.restfullbadgesystem.services.MembershipServiceImpl;
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

import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class MembershipServiceTests {
    @TestConfiguration
    static class MembershipServiceImplTestContextConfiguration {
        @Bean
        public MembershipService membershipService() {
            return new MembershipServiceImpl();
        }
    }

    @Autowired
    private MembershipService membershipService;

    @MockBean
    private MembershipDAO membershipDAO;

    @Before
    public void setUp() {
        LimitedMembership limitedMembership = new LimitedMembership(LocalDate.of(2022,05,17),
                LocalDate.of(2022,06,17), null, null, 20, 0);

        Mockito.when(membershipDAO.save(limitedMembership)).thenReturn(limitedMembership);
        Mockito.when(membershipDAO.findById(1)).thenReturn(Optional.of(limitedMembership));
    }

    @Test
    public void whenAllDetailsThenMembershipShouldBeCreated() {
        LimitedMembership limitedMembership = new LimitedMembership(LocalDate.of(2022,05,17),
                LocalDate.of(2022,06,17), null, null, 20, 0);

        LimitedMembership savedLimitedMembership = membershipService.createLimitedMembership(limitedMembership);

        Assert.assertEquals(limitedMembership, savedLimitedMembership);
    }

    @Test
    public void whenValidIdThenMembershipShouldBeFound() {
        LimitedMembership limitedMembership = new LimitedMembership(LocalDate.of(2022,05,17),
                LocalDate.of(2022,06,17), null, null, 20, 0);

        LimitedMembership searchedLimitedMembership = membershipService.getMembership(1);
        Assert.assertEquals(limitedMembership, searchedLimitedMembership);
    }
}
