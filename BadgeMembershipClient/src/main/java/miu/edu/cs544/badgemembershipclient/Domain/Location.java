package miu.edu.cs544.badgemembershipclient.Domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class Location {
    private int id;

    private String name;
    private String description;
    private int capacity;
    private String address;

    private Collection<LocationType> types;

    private Collection<TimeSlot> timeSlots = new ArrayList<>();

    private int occupied = 0;
}
