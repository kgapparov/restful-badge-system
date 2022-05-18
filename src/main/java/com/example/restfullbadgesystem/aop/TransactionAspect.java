package com.example.restfullbadgesystem.aop;

import com.example.restfullbadgesystem.domain.*;
import com.example.restfullbadgesystem.dto.CheckInDTO;
import com.example.restfullbadgesystem.service.LocationService;
import com.example.restfullbadgesystem.service.TransactionQueuePublisherService;
import com.example.restfullbadgesystem.services.BadgeService;
import com.example.restfullbadgesystem.services.MemberService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class TransactionAspect {
    @Autowired
    private TransactionQueuePublisherService publisher;

    @Autowired
    private BadgeService badgeService;

    @Autowired
    private LocationService locationService;

    @Pointcut("execution(* com.example.restfullbadgesystem.services.CheckInService.Check* (..)) && args(checkin)")
    public void getCheckInTransactions(JoinPoint joinPoint, CheckInDTO checkin){
        Transaction transaction = new Transaction();
        Badge badge = badgeService.getBadge(checkin.badgeId);
        Location location = locationService.getLocation(checkin.locationId);
        transaction.setMember(badge.getMember());
        transaction.setLocation(location);
        transaction.setType(TransactionType.CHECKIN);
        transaction.setDateTime(LocalDateTime.now());
        publisher.send(transaction);
    }
}
