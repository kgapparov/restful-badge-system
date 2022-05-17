package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.LimitedMembership;
import com.example.restfullbadgesystem.domain.Location;
import com.example.restfullbadgesystem.domain.LocationType;
import com.example.restfullbadgesystem.domain.Plan;
import com.example.restfullbadgesystem.dto.CheckInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class CheckInServiceImpl implements CheckInService
{


   @Autowired
   BadgeService badgeService;

  //  @Autowired
  //  LocationService locationService;

  //  @Autowired
 //   PlanService planService;

  //  @Autowired
  //  MemberService memberService;

    @PersistenceContext
    private EntityManager entityManager;

    public boolean CheckIn(CheckInDTO checkInDTO){



        boolean accessAllowed = false;

        Query planquery =  entityManager.createQuery("from Plan p JOIN p.memberships ms "+
                " JOIN ms.member m " +
               "JOIN m.badges bd WHERE bd.id = :badgeId "
                     );


        planquery.setParameter("badgeId", checkInDTO.badgeId);
        List<Object[]> planlist =  planquery.getResultList();
        Plan plan = (Plan) planlist.get(0)[0];


        Query query =  entityManager.createQuery("from Location l where  l.id = :locationId ");
        query.setParameter("locationId", checkInDTO.locationId);
        List<Location> list =  query.getResultList();
        Location location = list.get(0);
        System.out.println("Location result"+list.get(0).toString());

        Query memberShipquery =  entityManager.createQuery("from LimitedMembership lm JOIN lm.member m JOIN m.badges bd  "+
                "WHERE bd.id = :badgeId "
        );
        memberShipquery.setParameter("badgeId", checkInDTO.badgeId);
        List<Object[]> memberShipList =  memberShipquery.getResultList();

        System.out.println(memberShipList.get(0)[0]+"<<<<<<<<<<<.>>>>>>>>>>>>>>");

        boolean limitexceed = true;
        /*if(memberShipList!=null && memberShipList.size()>0 && memberShipList.get(0).length>0
        ){
            LimitedMembership limitedMembership =  (LimitedMembership)memberShipList.get(0)[0] ;
            if(limitedMembership.getLimit()> limitedMembership.getEntryCount()){
                limitexceed = false;
            }

        }*/

        boolean isAllowrdTypeIncluded = false;
        if(list!= null && list.size()>0){
        for (LocationType locationType : plan.getAllowedLocationTypes()){
            for(LocationType locationTypeRoom : location.getTypes()){
                System.out.println(locationType+"??????????????????" +locationTypeRoom);
                if(locationType.equals(locationTypeRoom)){

                    isAllowrdTypeIncluded = true;
                }
            }
        }
        }
        //System.out.println(badgeService.getBadge(checkInDTO.badgeId).getActive()+"??????????????");
       /* System.out.println(isAllowrdTypeIncluded+"isAllowrdIncluded");
      if(badgeService.getBadge(checkInDTO.badgeId)!=null && badgeService.getBadge(checkInDTO.badgeId).getActive()!=null &&
              badgeService.getBadge(checkInDTO.badgeId).getActive() &&// check badge status
             isAllowrdTypeIncluded &&
              location.getCapacity() > location.getOccupied() &&
              !limitexceed &&
              checkCurrentTimeAvailable(location)
      )*/
        {
            // this plan allow to access this location or
            // current timeslot between location available timeslot
            // < max limit for current month total availabe usage or

            accessAllowed=true;
        }

        return accessAllowed;
    }

    public boolean checkCurrentTimeAvailable(Location location){
        // code here

        return true;
    }
}
