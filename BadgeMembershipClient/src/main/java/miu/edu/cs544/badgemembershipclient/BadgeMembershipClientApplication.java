package miu.edu.cs544.badgemembershipclient;

import miu.edu.cs544.badgemembershipclient.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@SpringBootApplication
public class BadgeMembershipClientApplication implements CommandLineRunner {

    @Autowired
    @Lazy
    private RestOperations restTemplate;

    private String serverURL = "http://localhost:9191";
    private int memberId = 1;
    private int planId = 1;
    private int selectedLocationId = 1;

    public static void main(String[] args) {
        SpringApplication.run(BadgeMembershipClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\n\n------------------ Initailizing Client ------------------");
        System.out.println("\n*************Getting Badges************");
        Badge[] badges = restTemplate.getForObject(serverURL + "/members/" + memberId + "/badges", Badge[].class);

        System.out.println("\n------------------Received the following Badges From Server------------------");
        System.out.println("-----Badge ID--------------------"
                + "IssueDate---------------------"
                + "ExpireDate--------------------"
                +"Is Active----------------");
        for (Badge badge: badges) {
            System.out.printf("%10s%30s%30s%30s\n",
                    badge.getId(), badge.getIssueDate(), badge.getExpireDate(), badge.getIsActive());
        }

        System.out.println("\n\n------------------Filtering the active Badge------------------");
        Badge activeBadge;
        try {
            activeBadge = Stream.of(badges).filter(Badge::getIsActive).toList().get(0);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            activeBadge = new Badge();
        }
        System.out.println("-----Badge ID--------------------"
                + "Issue Date---------------------"
                + "Expire Date--------------------"
                +"Is Active----------------");
        System.out.printf("%10s%30s%30s%30s\n",
                activeBadge.getId(), activeBadge.getIssueDate(), activeBadge.getExpireDate(), activeBadge.getIsActive());


        System.out.println("\n*************Getting list of Memberships for CHECKER************");
        Membership[] memberships = restTemplate.getForObject(serverURL+"/members/"+memberId+"/memberships", Membership[].class);
        System.out.println("\n------------------Received the following Memberships From Server------------------");
        System.out.println("-----Membership ID---------------"
                + "Start Date---------------------"
                + "End Date--------------------"
                +"Plan----------------");
        for(Membership ms: memberships) {
            System.out.printf("%10s%30s%30s%30s\n",
                    ms.getId(), ms.getStartDate(), ms.getEndDate(), ms.getPlan().getName());
        }

        System.out.println("\n*************Getting list of Plans************");
        Plan[] plans = restTemplate.getForObject(serverURL+"/members/"+memberId+"/plans", Plan[].class);
        System.out.println("\n------------------Received the following Plans From Server------------------");
        System.out.println("-----Plan ID--------------------"
                + "Name-------------------------------"
                + "Description--------------------");
        for(Plan p: plans) {
            System.out.printf("%8s%30s%50s\n",
                    p.getId(), p.getName(), p.getDescription());
        }

        System.out.println("\nAssuming PlanID--"+planId+" was selected");
        System.out.println("\n*************Getting list of Locations for Plan "+planId+"************");
        Location[] locations = restTemplate.getForObject(serverURL+"/plans/"+planId+"/locations", Location[].class);
        System.out.println("\n------------------Received the following Locations From Server------------------");
        System.out.println("-----Location ID--------------------"
                + "Name-------------------------------"
                + "Capacity--------------------"
                + "Description-----------------");
        for(Location l: locations) {
            System.out.printf("%8s%40s%30s%30s\n",
                    l.getId(), l.getName(), l.getCapacity(), l.getDescription());
        }

        System.out.println("\n*************Simulating CheckIn************");
        String checkinMessage = restTemplate.postForObject(serverURL+"/checkIn",
                new CheckinDTO(selectedLocationId, activeBadge.getId()),
                String.class);
        System.out.println("Checkin Message Received From Server:");
        System.out.println(checkinMessage);
    }

    @Bean
    RestOperations restTemplate() {
        return new RestTemplate();
    }
}
