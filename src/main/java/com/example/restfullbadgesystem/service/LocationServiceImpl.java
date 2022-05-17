package com.example.restfullbadgesystem.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restfullbadgesystem.domain.Location;
import com.example.restfullbadgesystem.domain.Member;
import com.example.restfullbadgesystem.domain.TimeSlot;
import com.example.restfullbadgesystem.repositories.LocationDAO;

@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
	LocationDAO repository;
 
	public Location getLocation(int id) {
		return repository.findById(id).get();
	}
	public Collection<Location> getAllLocations() {
		return repository.findAll();
	}
	public Location createLocation(Location location) {
		return repository.save(location);
	}
	public void updateLocation(Location newLocation) {
		repository.save(newLocation);
	}
	
	public void removeLocation(int locationId) {
		repository.deleteById(locationId);
	}
}
