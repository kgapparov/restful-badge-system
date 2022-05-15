package com.example.restfullbadgesystem.repositories;

import com.example.restfullbadgesystem.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDAO extends JpaRepository<Location, Integer> {
}
