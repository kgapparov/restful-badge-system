package com.example.restfullbadgesystem.controllers;

import java.util.Collection;
import java.util.List;

import javax.annotation.security.RolesAllowed;

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
	
	@RolesAllowed({"user", "admin"})
	@GetMapping
	public Collection<Location> getAllLocations() {
		return service.getAllLocations();
	}
	
	@RolesAllowed({"user", "admin"})
	@GetMapping("/{id}")
	public Location getLocation(int id) {
		return service.getLocation(id);
	}
	
	@RolesAllowed({"admin"})
	@PostMapping("/")
	public Location createLocation(@RequestBody Location location) {
		return service.createLocation(location);
	}
	
	@RolesAllowed({"admin"})
	@DeleteMapping("/{id}")
	public void removeLocation(@PathVariable int locationId) {
		service.removeLocation(locationId);
	}
	
	@RolesAllowed({"admin"})
	@PutMapping("/{id}")
	public void updateLocation(Location newLocation) {
		service.updateLocation(newLocation);
	}
}
