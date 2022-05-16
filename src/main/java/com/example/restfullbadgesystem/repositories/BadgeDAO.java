package com.example.restfullbadgesystem.repositories;

import com.example.restfullbadgesystem.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeDAO extends JpaRepository<Badge, Long> {
}
