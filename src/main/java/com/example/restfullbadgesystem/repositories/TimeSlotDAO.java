package com.example.restfullbadgesystem.repositories;

import com.example.restfullbadgesystem.domain.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotDAO extends JpaRepository<TimeSlot, Integer> {
}
