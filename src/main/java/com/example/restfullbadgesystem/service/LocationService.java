package com.example.restfullbadgesystem.service;

import java.util.Collection;

import com.example.restfullbadgesystem.domain.Location;
import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.domain.TimeSlot;

public interface LocationService {
	public Location getLocation(int id);
	public Collection<Location> getAllLocations();
	public Location createLocation(Location location);
	public void updateLocation(Location newLocation, int oldLocationId);
	public void removeLocation(int locationId);
	public void updateTimeSlots(int locationId, Collection<TimeSlot> timeSlots);
	public void updateCapacity(int locationId, int capacity);
	public void increaseOccupied(int locationId);
	public void decreaseOccupied(int locationId);
	public void resetOccupied(int locationId);
}
