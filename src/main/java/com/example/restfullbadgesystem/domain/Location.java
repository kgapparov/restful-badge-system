package com.example.restfullbadgesystem.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private int capacity;
    private String address;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Collection<LocationType> types;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<TimeSlot> timeSlots = new ArrayList<>();

    @Transient
    private int occupied = 0;

	public Location(String name, String description, int capacity, String address, Collection<LocationType> types,
			Collection<TimeSlot> timeSlots) {
		this.name = name;
		this.description = description;
		this.capacity = capacity;
		this.address = address;
		this.types = types;
		this.timeSlots = timeSlots;
	}
	
	public Boolean isCurrenTimeWithinTimeSlots() {
		LocalDateTime currentTime = LocalDateTime.now();
		for (TimeSlot timeSlot : timeSlots) {
			for (DayOfWeek dayOfWeek : timeSlot.getDaysOfWeek()) {
				if (dayOfWeek.equals(currentTime.getDayOfWeek()) && isTimeWithinTimeSlot(currentTime, timeSlot)) {
					return true;
				}
			}
		}
		return false;
	}

	private Boolean isTimeWithinTimeSlot(LocalDateTime currentTime, TimeSlot timeSlot) {
		Boolean isAfterStartTime = false;
		if (currentTime.getHour() == timeSlot.getStartTime().getHour()) {
			if (currentTime.getMinute() >= timeSlot.getStartTime().getMinute()) {
				isAfterStartTime = true;
			}
		} else if (currentTime.getHour() > timeSlot.getStartTime().getHour()) {
			isAfterStartTime = true;
		}

		Boolean isBeforeEndTime = false;
		if (currentTime.getHour() == timeSlot.getEndTime().getHour()) {
			if (currentTime.getMinute() < timeSlot.getEndTime().getMinute()) {
				isBeforeEndTime = true;
			}
		} else if (currentTime.getHour() < timeSlot.getEndTime().getHour()) {
			isBeforeEndTime = true;
		}

		return isAfterStartTime && isBeforeEndTime;
	}
}
