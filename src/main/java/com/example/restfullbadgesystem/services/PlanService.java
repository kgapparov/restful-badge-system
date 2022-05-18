package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.*;

import java.util.Collection;

public interface PlanService {
    public Plan createPlan(Plan plan);
    public Plan getPlan(int id);
    public Plan updatePlan(Plan plan);
    public Collection<Location> getAllLocationsForPlan(int id);
}
