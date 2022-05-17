package com.example.restfullbadgesystem.repositories;

import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PlanDAO extends JpaRepository<Plan, Integer> {
//    Collection<Plan> findAllByMember(Member member);
}
