package com.example.restfullbadgesystem.service;

import com.example.restfullbadgesystem.domain.*;
import com.example.restfullbadgesystem.repositories.TransactionDAO;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
class TransactionServiceTest {
    @TestConfiguration
    static class  TransactionServiceImplTestContextConfiguration {
        @Bean
        public TransactionService transactionService(){
            return new TransactionServiceImpl();
        }
    }

    @Autowired
    private TransactionService transactionService;

    @MockBean
    private TransactionDAO transactionDAO;

    private Transaction expected;

    private Member member;

    private Location location;
    @Before
    public void setUp() {
        //create location
        location = new Location();
        location.setAddress("551 Kirkwood ave");
        location.setCapacity(100);
        location.setDescription("Restoraunt");
        location.setName("Test");
        location.setTypes(Arrays.asList(LocationType.DINING_HALL, LocationType.MEDITATION_HALL));
        //create member
        member = new Member();
        member.setBadges(List.of(new Badge(member)));
        member.setEmailAddress("member@gmail.com");
        member.setFirstName("memberName");
        member.setLastName("memberLast name");
        member.setRoles(Arrays.asList(Role.STUDENT, Role.STAFF));

        expected = new Transaction(LocalDateTime.now(), member, location, TransactionType.CHECKIN);

        Mockito.when(transactionDAO.save(expected)).thenReturn(expected);
        Mockito.when(transactionDAO.findAllByMember(member)).thenReturn(List.of(expected));
        Mockito.when(transactionDAO.findById(1)).thenReturn(Optional.of(expected));
    }

    @Test
    void findAllByMember() {
        Collection<Transaction> result = transactionService.findAllByMember(member);
        Assertions.assertArrayEquals(result.toArray(), List.of(expected).toArray());
        System.out.println(transactionService);
    }
}