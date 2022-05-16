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
	public void updateLocation(Location newLocation, int oldLocationId) {
		Location oldLocation = repository.findById(oldLocationId).get();
		if (oldLocation != null) {
			repository.delete(oldLocation);
		} 
		
		newLocation.setId(oldLocationId);
		repository.save(newLocation);
	}
	
	public void removeLocation(int locationId) {
		repository.deleteById(locationId);
	}
	
	public void updateTimeSlots(int locationId, Collection<TimeSlot> timeSlots) {
		Location location = repository.findById(locationId).get();
		if (location != null) {
			location.setTimeSlots(timeSlots);
			repository.save(location);
		}
	}
	public void updateCapacity(int locationId, int capacity) {
		Location location = repository.findById(locationId).get();
		if (location != null) {
			location.setCapacity(capacity);
			repository.save(location);
		}
	}

	public void increaseOccupied(int locationId) {
		Location location = repository.findById(locationId).get();
		if (location != null) {
			int occupied = location.getOccupied();
			location.setOccupied(occupied + 1);
			repository.save(location);
		}
	}

	public void decreaseOccupied(int locationId) {
		Location location = repository.findById(locationId).get();
		if (location != null) {
			int occupied = location.getOccupied();
			location.setOccupied(occupied - 1);
			repository.save(location);
		}
	}

	public void resetOccupied(int locationId) {
		Location location = repository.findById(locationId).get();
		if (location != null) {
			location.setOccupied(0);
			repository.save(location);
		}
	}
	
}
