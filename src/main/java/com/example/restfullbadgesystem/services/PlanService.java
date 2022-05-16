package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.LocationType;
import com.example.restfullbadgesystem.domain.Membership;
import com.example.restfullbadgesystem.domain.Plan;
import com.example.restfullbadgesystem.domain.Role;

import java.util.Collection;

public interface PlanService {
    public Plan createPlan(Plan plan);
    public Plan getPlan(int id);
    public Plan updatePlan(Plan plan);
}
