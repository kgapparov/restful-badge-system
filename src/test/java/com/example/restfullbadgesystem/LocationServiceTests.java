package com.example.restfullbadgesystem;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import com.example.restfullbadgesystem.domain.Location;
import com.example.restfullbadgesystem.domain.LocationType;
import com.example.restfullbadgesystem.domain.TimeSlot;
import com.example.restfullbadgesystem.repositories.LocationDAO;
import com.example.restfullbadgesystem.service.LocationService;

import org.junit.Assert;

@RunWith(SpringRunner.class)
public class LocationServiceTests {	
	@Autowired
	private LocationService service;
	
	@MockBean
	private LocationDAO repository;
	
	@Before
	public void setUp() {
		int id = 12345;
		Collection<DayOfWeek> daysOfWeek = Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY);
		Collection<TimeSlot> timeslots = Arrays.asList(new TimeSlot(LocalTime.of(9, 0),LocalTime.of(17, 0),daysOfWeek));
		Collection<LocationType> types = Arrays.asList(LocationType.DINING_HALL);
		Location location = new Location("Dabby Hall", "Hall", 200, "MIU address", types, timeslots);
		
		Optional<Location> optionalLocation = Optional.of(location);
		Mockito.when(repository.findById(id)).thenReturn(optionalLocation);
		Mockito.when(service.createLocation(location)).thenReturn(location);
	}
	
	@Test
	public void testLocationCreation() {
		int id = 12345;
		Collection<DayOfWeek> daysOfWeek = Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY);
		Collection<TimeSlot> timeslots = Arrays.asList(new TimeSlot(LocalTime.of(9, 0),LocalTime.of(17, 0),daysOfWeek));
		Collection<LocationType> types = Arrays.asList(LocationType.DINING_HALL);
		Location location = new Location("Dabby Hall", "Hall", 200, "MIU address", types, timeslots);
		Location createdLocation = service.createLocation(location);
		Assert.assertEquals(location, createdLocation);
	}
	
	@Test
	public void testGetLocation() {
		int id = 12345;
		Location found = service.getLocation(id);
		Assert.assertEquals(id, found.getId());
	}
}
