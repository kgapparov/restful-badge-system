package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.LocationType;
import com.example.restfullbadgesystem.domain.Membership;
import com.example.restfullbadgesystem.domain.Plan;
import com.example.restfullbadgesystem.domain.Role;
import com.example.restfullbadgesystem.repositories.PlanDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanDAO planDAO;

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
}
