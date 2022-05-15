package com.example.restfullbadgesystem.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Entity
@Data
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated
    private DayOfWeek dayOfWeek; // enum DayOfWeek is already available since Java 1.8
}
