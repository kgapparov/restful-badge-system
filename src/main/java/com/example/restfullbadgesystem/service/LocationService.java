package com.example.restfullbadgesystem.service;

import java.util.Collection;

import com.example.restfullbadgesystem.domain.Location;
import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.domain.TimeSlot;

public interface LocationService {
	public Location getLocation(int id);
	public Collection<Location> getAllLocations();
	public Location createLocation(Location location);
	public void updateLocation(Location newLocation);
	public void removeLocation(int locationId);
}
