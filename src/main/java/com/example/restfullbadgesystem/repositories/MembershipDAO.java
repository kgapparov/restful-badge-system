package com.example.restfullbadgesystem.repositories;

import com.example.restfullbadgesystem.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipDAO<T extends Membership> extends JpaRepository<T, Integer> {
}
