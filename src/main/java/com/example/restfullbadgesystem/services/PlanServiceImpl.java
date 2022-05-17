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
        return planDAO.findById(id).orElse(null);
    }

    public Plan updatePlan(Plan plan) {
        return planDAO.save(plan);
    }

    @Override
    public Collection<Location> getAllLocationsForPlan(int id) {
        return locationService.getAllLocations().stream()
                .filter(location -> location.getTypes().stream().anyMatch(planDAO.getById(id).getAllowedLocationTypes()::contains))
                .toList();
    }
}
