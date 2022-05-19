
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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


enum CheckinStatus {
    CHECKIN, CHECKOUT, DENIED
}
@Service
public class CheckInServiceImpl implements CheckInService {
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

        Badge badge = badgeService.getBadge(checkInDTO.badgeId);
        Location location = locationService.getLocation(checkInDTO.locationId);
        boolean badgeStatus = badge.getIsActive();

        int activeBadgeMemberId = badge.getMember().getId();


        Membership membership = membershipService.getMembership(activeBadgeMemberId);
        LimitedMembership limitedMembership = membershipService.getMembership(activeBadgeMemberId);

        //for active member
        if (badgeStatus) {

            //checking  location is not included in membership plan allow location type

            Collection<Plan> plansForActiveMember = memberService.getPlansForMember(activeBadgeMemberId);
            Collection<LocationType> allowedLocationsForActiveMember = new ArrayList<>();

            for (Plan plan : plansForActiveMember) {
                for (LocationType locationType : plan.getAllowedLocationTypes()) {
                    allowedLocationsForActiveMember.add(locationType);
                    System.out.println("locationType" + locationType.toString());
                }
            }

            allowedLocationsForActiveMember = allowedLocationsForActiveMember.stream().distinct().toList();
            Boolean allowAccess = location.getTypes().stream().anyMatch(allowedLocationsForActiveMember::contains);

            if (!allowAccess) {
                return "Your membership type does not allow to access to this location.";
            }
            else {
                    //checking current date and time == location open date and time

                    boolean isCurrenTimeWithinTimeSlots = false;
                    LocalTime currentTime = LocalTime.now();
                    LocalDate currentDay = LocalDate.now();
                    Collection<TimeSlot> timeSlotList = location.getTimeSlots();

                    if (timeSlotList != null && timeSlotList.size() > 0) {
                        for (TimeSlot timeSlot : timeSlotList) {
                              if (currentTime.isAfter(timeSlot.getStartTime()) && currentTime.isBefore(timeSlot.getEndTime())) {
                                for (DayOfWeek dayOfWeek : timeSlot.getDaysOfWeek()) {
                                    if (dayOfWeek.equals(currentDay.getDayOfWeek())) {
                                        isCurrenTimeWithinTimeSlots = true;
                                        break;
                                    }
                                }

                            }
                        }
                    }


                    if (!isCurrenTimeWithinTimeSlots)
                        return "This place is close. Please check our opening hour.";

                    else {
                        // checking 3. This place reach maximum occupants.

                        if (location.getCapacity() <= location.getOccupied())
                            return "This place reach maximum occupants.";
                        //for limited membership

                        if (limitedMembership.getLimit() != null && limitedMembership.getConsumed() >= limitedMembership.getLimit())
                            return "You already reach maximum allow access to this place.";

                        return "Check In Success";
                    }
            }
        } else return "Invalid Member Card";
    }
}
