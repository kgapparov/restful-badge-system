package com.example.restfullbadgesystem.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private LocationType type;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<TimeSlot> timeSlots = new ArrayList<>();
}
