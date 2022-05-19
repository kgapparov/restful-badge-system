package miu.edu.cs544.badgemembershipclient.Feign;

import miu.edu.cs544.badgemembershipclient.Domain.Badge;
import miu.edu.cs544.badgemembershipclient.Domain.Location;
import miu.edu.cs544.badgemembershipclient.Domain.Membership;
import miu.edu.cs544.badgemembershipclient.Domain.Plan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface ClientFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/members/${server-service.memberId}/badges")
    List<Badge> getBadges();

    @RequestMapping(method = RequestMethod.GET, value = "/members/${server-service.memberId}/memberships")
    List<Membership> getMemberships();

    @RequestMapping(method = RequestMethod.GET, value = "/members/${server-service.memberId}/plans")
    List<Plan> getPlans();

    @RequestMapping(method = RequestMethod.GET, value = "/plans/${server-service.memberId}/locations")
    List<Location> getLocations();
}
