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
}
