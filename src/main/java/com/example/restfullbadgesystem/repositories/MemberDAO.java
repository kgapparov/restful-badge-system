package com.example.restfullbadgesystem.repositories;

import com.example.restfullbadgesystem.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO extends JpaRepository<Member, Integer> {
}
