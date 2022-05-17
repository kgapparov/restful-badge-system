package com.example.restfullbadgesystem.repositories;

import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MembershipDAO<T extends Membership> extends JpaRepository<T, Integer> {
    public Collection<T> findAllByMember(Member member);
}
