package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.*;
import com.example.restfullbadgesystem.repositories.PlanDAO;
import com.example.restfullbadgesystem.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanDAO planDAO;

    @Autowired
    LocationService locationService;

    @Override
    public Plan createPlan(Plan plan) {
        return planDAO.save(plan);
    }

    public Plan getPlan(int id) {
        System.out.println("Plan Service Impl -> getPlan -> " + id);
        return planDAO.findById(id).get();
    }

    public Plan updatePlan(Plan plan) {
        return planDAO.save(plan);
    }

//    @Override
//    public Collection<Plan> getAllPlansByMember(Member member) {
//        return planDAO.findAllByMember(member);
//    }

    @Override
    public Collection<Location> getAllLocationsForPlan(int id) {
        Collection<Location> allLocationsForPlan = locationService.getAllLocations().stream()
                .filter(location -> location.getTypes().stream().anyMatch(planDAO.getById(id).getAllowedLocationTypes()::contains))
                .toList();

        return allLocationsForPlan;
    }
}
