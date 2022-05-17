package com.example.restfullbadgesystem;

import com.example.restfullbadgesystem.domain.LocationType;
import com.example.restfullbadgesystem.domain.Membership;
import com.example.restfullbadgesystem.domain.Plan;
import com.example.restfullbadgesystem.domain.Role;
import com.example.restfullbadgesystem.repositories.PlanDAO;
import com.example.restfullbadgesystem.services.PlanService;
import com.example.restfullbadgesystem.services.PlanServiceImpl;
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
public class PlanServiceTests {

    @TestConfiguration
    static class PlanServiceImplTestContextConfiguration{
        @Bean
        public PlanService planService() {
            return new PlanServiceImpl();
        }
    }

    @Autowired
    private PlanService planService;

    @MockBean
    private PlanDAO planDAO;

    @Before
    public void setUp() {
        Collection<Membership> memberships = new ArrayList<>();
        Collection<Role> roles = new ArrayList<>();
        roles.add(Role.STUDENT);
        Collection<LocationType> allowedLocationTypes = new ArrayList<>();
        allowedLocationTypes.add(LocationType.DINING_HALL);
        Plan plan = new Plan("Meal Plan", "The meal plan that allows to have 90 meals per month",
                memberships, roles, allowedLocationTypes);

        Mockito.when(planDAO.save(plan)).thenReturn(plan);
        Mockito.when(planDAO.findById(1)).thenReturn(Optional.of(plan));
    }

    @Test
    public void whenAllDetailsThenPlanShouldBeCreated() {
        Collection<Role> roles = new ArrayList<>();
        roles.add(Role.STUDENT);
        Collection<LocationType> allowedLocationTypes = new ArrayList<>();
        allowedLocationTypes.add(LocationType.DINING_HALL);
        Plan plan = new Plan("Meal Plan", "The meal plan that allows to have 90 meals per month",
                new ArrayList<>(), roles, allowedLocationTypes);

        Plan savedPlan = planService.createPlan(plan);

        Assert.assertEquals(plan, savedPlan);
    }

    @Test
    public void whenValidIdThenPlanShouldBeFound() {
        Collection<Role> roles = new ArrayList<>();
        roles.add(Role.STUDENT);
        Collection<LocationType> allowedLocationTypes = new ArrayList<>();
        allowedLocationTypes.add(LocationType.DINING_HALL);
        Plan plan = new Plan("Meal Plan", "The meal plan that allows to have 90 meals per month",
                new ArrayList<>(), roles, allowedLocationTypes);

        Plan searchedPlan = planService.getPlan(1);

        Assert.assertEquals(plan, searchedPlan);
    }
}
