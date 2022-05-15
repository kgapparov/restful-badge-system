package com.example.restfullbadgesystem.repositories;

import com.example.restfullbadgesystem.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanDAO extends JpaRepository<Plan, Integer> {
}
