package com.example.restfullbadgesystem.services;


import com.example.restfullbadgesystem.domain.*;
import com.example.restfullbadgesystem.dto.CheckInDTO;
import com.example.restfullbadgesystem.domain.LimitedMembership;
import com.example.restfullbadgesystem.domain.Location;
import com.example.restfullbadgesystem.domain.LocationType;
import com.example.restfullbadgesystem.domain.Plan;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


enum CheckinStatus {
    CHECKIN, CHECKOUT, DENIED
}
@Service
public class CheckInServiceImpl implements CheckInService
{


    @PersistenceContext
    private EntityManager entityManager;

    public String CheckIn(CheckInDTO checkInDTO) {
        boolean accessAllowed = false;
        String checkinMessage = null;

        Query badgequery = entityManager.createQuery("from Badge b where b.id= :badgeId");
        badgequery.setParameter("badgeId", checkInDTO.badgeId);
        List<Badge> badgeList = badgequery.getResultList();
        System.out.println("Badge result>>>>>>>>>>>" + badgeList.get(0).getIsActive() + ">>>>>>>>>>>>>>>>>>" + badgeList.get(0).toString());

        //for not active badge
        if (!badgeList.get(0).getIsActive()) {
            checkinMessage = "Not Active Badge";

        }
        //for active badge
        else if (badgeList.get(0).getIsActive()) {
            checkinMessage="Active Badge";
            Query planquery = entityManager.createQuery("from Plan p JOIN p.memberships ms " +
                    " JOIN ms.member m " +
                    "JOIN m.badges bd WHERE bd.id = :badgeId "
            );


            planquery.setParameter("badgeId", checkInDTO.badgeId);
            List<Object[]> planlist = planquery.getResultList();
            Plan plan = (Plan) planlist.get(0)[0];


            Query query = entityManager.createQuery("from Location l where  l.id = :locationId ");
            query.setParameter("locationId", checkInDTO.locationId);
            List<Location> locationList = query.getResultList();
            Location location = locationList.get(0);
            System.out.println("Location result" + locationList.get(0).toString());

            /*public boolean checkCurrentTimeAvailable(Location loc){
                // code here

                return 1;
            }

            */

            Query memberShipquery = entityManager.createQuery("from LimitedMembership lm JOIN lm.member m JOIN m.badges bd  " +
                    "WHERE bd.id = :badgeId "
            );

            memberShipquery.setParameter("badgeId", checkInDTO.badgeId);
            List<Object[]> memberShipList = memberShipquery.getResultList();

            System.out.println(memberShipList.get(0)[0] + "<<<<<<<<<<<.>>>>>>>>>>>>>>");

            boolean limitexceed = true;
            if (memberShipList != null && memberShipList.size() > 0 && memberShipList.get(0).length > 0) {
                LimitedMembership limitedMembership = (LimitedMembership) memberShipList.get(0)[0];
                if (limitedMembership.getLimit() > limitedMembership.getConsumed()) {
                    limitexceed = false;
                }

            }

            boolean isAllowrdTypeIncluded = false;
            if (locationList != null && locationList.size() > 0) {
                for (LocationType locationType : plan.getAllowedLocationTypes()) {
                    for (LocationType locationTypeRoom : location.getTypes()) {
                        System.out.println(locationType + "??????????????????" + locationTypeRoom);
                        if (locationType.equals(locationTypeRoom)) {

                            isAllowrdTypeIncluded = true;
                        }
                    }
                }
            }
            // System.out.println(badgeService.getBadge(checkInDTO.badgeId).getActive() + "??????????????");
            // System.out.println(isAllowrdTypeIncluded + "isAllowrdIncluded");

            if (badgeList.get(0).getIsActive() &&
                    //badgeService.getBadge(checkInDTO.badgeId) != null && badgeService.getBadge(checkInDTO.badgeId).getActive() != null &&
                    //badgeService.getBadge(checkInDTO.badgeId).getActive() &&// check badge status
                    isAllowrdTypeIncluded &&
                    location.getCapacity() > location.getOccupied() &&
                    !limitexceed //&&
                // checkCurrentTimeAvailable(location)
            ) {
                // this plan allow to access this location or
                // current timeslot between location available timeslot
                // < max limit for current month total availabe usage or

                accessAllowed = true;
            }

            //return accessAllowed;

        }

        return checkinMessage;

    }


//    @Autowired
//    private BadgeService badgeService;
//
//    @Autowired
//    private LocationService locationService;
//
//    @Autowired PlanService planService;
//
//    @Override
//    public String CheckIn(CheckInDTO checkInDTO) {
//        Badge badge = badgeService.getBadge(checkInDTO.badgeId);
//        Location location = locationService.getLocation(checkInDTO.locationId);
//        //1 isActive
//        boolean badgeStatus = badge.getIsActive();
//        //getMembership
//        Collection<Membership> memberShips = badge.getMember().getMemberships();
//        for (Membership membership : memberShips) {
//
//        }
//
//    }
}
