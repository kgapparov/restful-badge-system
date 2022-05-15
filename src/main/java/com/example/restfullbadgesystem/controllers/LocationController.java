package com.example.restfullbadgesystem.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfullbadgesystem.domain.Location;
import com.example.restfullbadgesystem.domain.TimeSlot;
import com.example.restfullbadgesystem.service.LocationServiceImpl;

@RestController
@RequestMapping("/locations")
public class LocationController {
	@Autowired
	private LocationServiceImpl service;
	
	@GetMapping
	public Collection<Location> getAllLocations() {
		return service.getAllLocations();
	}
	
	@GetMapping("/{id}")
	public Location getLocation(int id) {
		return service.getLocation(id);
	}
	
	@PostMapping("/")
	public Location createLocation(@RequestBody Location location) {
		return service.createLocation(location);
	}
	
	@DeleteMapping("/{id}")
	public void removeLocation(Location newLocation, @PathVariable int oldLocationId) {
		service.updateLocation(newLocation, oldLocationId);
	}
	
	@PutMapping("/{id}")
	public void updateLocation(Location newLocation, @PathVariable int oldLocationId) {
		service.updateLocation(newLocation, oldLocationId);
	}
	
	@PatchMapping("/{id}")
	public void increaseOccupied(@PathVariable int locationId) {
		service.increaseOccupied(locationId);
	}
	
	@PatchMapping("/{id}")
	public void decreaseOccupied(@PathVariable int locationId) {
		service.decreaseOccupied(locationId);
	}
	
	@PatchMapping("/{id}")
	public void resetOccupied(@PathVariable int locationId) {
		service.resetOccupied(locationId);
	}
	
	@PatchMapping("/{id}")
	public void updateCapacity(@PathVariable int locationId, int capacity) {
		service.updateCapacity(locationId, capacity);
	}
	
	@PatchMapping("/{id}")
	public void updateTimeSlots(@PathVariable int locationId, Collection<TimeSlot> timeSlots) {
		service.updateTimeSlots(locationId, timeSlots);
	}
}
