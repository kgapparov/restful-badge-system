package com.example.restfullbadgesystem.services;


import com.example.restfullbadgesystem.domain.*;
import com.example.restfullbadgesystem.dto.CheckInDTO;
import com.example.restfullbadgesystem.domain.LimitedMembership;
import com.example.restfullbadgesystem.domain.Location;
import com.example.restfullbadgesystem.domain.LocationType;
import com.example.restfullbadgesystem.domain.Plan;
import com.example.restfullbadgesystem.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;



enum CheckinStatus {
    CHECKIN, CHECKOUT, DENIED
}
@Service
public class CheckInServiceImpl implements CheckInService
{
    @Autowired
    private BadgeService badgeService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private PlanService planService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MembershipService membershipService;



    @Override
    public String CheckIn(CheckInDTO checkInDTO) {
        String checkinMessage = null;

        System.out.println("checkInDTO.badgeId>>>>>>>>>>>>"+checkInDTO.badgeId);
        Badge badge = badgeService.getBadge(checkInDTO.badgeId);
        Location location = locationService.getLocation(checkInDTO.locationId);
        System.out.println("Location id>>>>>>>>>>>"+checkInDTO.locationId);
        //1 isActive
        boolean badgeStatus = badge.getIsActive();
        System.out.println("Badge status>>>>>>>>>>"+badge.getMember().getId());
        int activeBadgeMemberId= badge.getMember().getId();
        //boolean allowAccess;

        Membership membership=membershipService.getMembership(activeBadgeMemberId);
        LimitedMembership limitedMembership= membershipService.getMembership(activeBadgeMemberId);

        //Plan planforactiveMember=planService.getAllLocationsForPlan(pla);

        Collection<Plan> plansForActiveMember = memberService.getPlansForMember(activeBadgeMemberId);
        Collection<LocationType> allowedLocationsForActiveMember = new ArrayList<>();

        for(Plan plan: plansForActiveMember) {
            for(LocationType locationType: plan.getAllowedLocationTypes()){
                allowedLocationsForActiveMember.add(locationType);
                System.out.println("locationType"+locationType.toString());
            }
        }

        allowedLocationsForActiveMember = allowedLocationsForActiveMember.stream().distinct().toList();
        Boolean allowAccess = location.getTypes().stream().anyMatch(allowedLocationsForActiveMember::contains);

        // for not active member getBadgesForActiveMember
        if(!badgeStatus){
            checkinMessage="Invalid Member Card";
        }
        //for active member
        else {



            System.out.println("");
            if (location.getCapacity() <= location.getOccupied()) {
                checkinMessage = "This place reach maximum occupants.";
            }
            else{

                //for limited membership
                if(limitedMembership.getConsumed()>=limitedMembership.getLimit())
                    // checking 4.
                    checkinMessage = "You already reach maximum allow access to this place.";
                else
                    checkinMessage = "Check in Success";
            }


        }

        return checkinMessage;
    }//end of isActive badge

}
