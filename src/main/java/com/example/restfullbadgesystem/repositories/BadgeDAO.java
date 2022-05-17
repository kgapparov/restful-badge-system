package com.example.restfullbadgesystem.repositories;

import com.example.restfullbadgesystem.domain.Badge;
import com.example.restfullbadgesystem.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BadgeDAO extends JpaRepository<Badge, Long> {
    Collection<Badge> findAllByMember(Member member);
}
