package com.example.restfullbadgesystem.controllers;

import com.example.restfullbadgesystem.domain.Location;
import com.example.restfullbadgesystem.domain.Plan;
import com.example.restfullbadgesystem.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Collection;

@RestController
@RequestMapping("/plans")
public class PlanController {
    @Autowired
    private PlanService planService;

    @RolesAllowed({"admin", "user"})
    @GetMapping("/{id}")
    public Plan getPlanById(@PathVariable int id) {
        return planService.getPlan(id);
    }

    @RolesAllowed({"admin", "user"})
    @PostMapping
    public Plan createPlan(@RequestBody Plan plan) {
        return planService.createPlan(plan);
    }

    @RolesAllowed({"admin", "user"})
    @PutMapping("/{id}")
    public Plan updatePlan(@PathVariable int id, @RequestBody Plan plan) {
        return planService.updatePlan(plan);
    }

    @GetMapping("/{id}/locations")
    public Collection<Location> getAllLocationsForPlan(@PathVariable int id) {
        return planService.getAllLocationsForPlan(id);
    }
}
