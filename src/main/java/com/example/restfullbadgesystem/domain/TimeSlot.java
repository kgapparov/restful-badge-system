package com.example.restfullbadgesystem.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class TimeSlot {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalTime startTime;
    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Collection<DayOfWeek> daysOfWeek; // enum DayOfWeek is already available since Java 1.8
    
    public TimeSlot(LocalTime startTime, LocalTime endTime, Collection<DayOfWeek> daysOfWeek) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.daysOfWeek = daysOfWeek;
	}
}
