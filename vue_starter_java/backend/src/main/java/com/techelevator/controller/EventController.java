package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.authentication.RequestAuthProvider;
import com.techelevator.model.Address;
import com.techelevator.model.Event;
import com.techelevator.model.EventAttendees;
import com.techelevator.model.EventDao;
import com.techelevator.model.User;

@RestController
@RequestMapping("/api")
public class EventController {
	
	@Autowired
	private EventDao eventDao;
	
	/**
	 * 
	 */
	@GetMapping(path="/address/{addressid}")
	public Address getAddressByID(@PathVariable long addressid) {
		return eventDao.getAddress(addressid);
	}
	
	
	/**
	 * Gets a list of all the events for the currently logged in user.
	 * Roles: Anonymous
	 * 
	 * @return List of all the events for the user
	 */
    @GetMapping(path="/events")
    public List<Event> getEventsForUser(HttpServletRequest request, HttpServletResponse response) {
    	User user = (User)request.getAttribute(RequestAuthProvider.USER_KEY);
    	
    	return eventDao.getEventsForUser(user.getId());
    }
    
    /**
     * Create cookout
     * Roles: Host
     */
    @PostMapping(path="/events")
    public Event createEvent(Event event, Address address, HttpServletResponse response) {
    	response.setStatus(HttpServletResponse.SC_CREATED);
    	eventDao.addAddress(address);
    	return eventDao.createEvent(event, address);
    }
    
    /**
     * Views the cookout details for the specified event.
     * Roles: Attendee | Host | Chef
     */
    @GetMapping(path="/event/{eventid}")
    public Event getEventDetails(@PathVariable long eventid, HttpServletResponse response) {
    	return eventDao.getEventDetails(eventid);
    }
    
    /**
     * Deletes the specified event.
     * Roles: Host
     */
    @DeleteMapping(path="/event/{eventid}")
    public void deleteEvent(@PathVariable long eventid, HttpServletResponse response) {
    	eventDao.deleteEvent(eventid);
    	
    	// successfully deleted a record
    	response.setStatus(HttpServletResponse.SC_OK);
    	// no record to delete
    	response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    	// not authorized
    	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
    
    /**
     * Gets the attendees from the specified event.
     * Roles: Attendees | Host
     */
    @GetMapping(path="/event/{eventid}/attendees")
    public List<EventAttendees> getEventAttendees(@PathVariable long eventid, HttpServletResponse response) {
    	return eventDao.getEventAttendees(eventid);
    }
    
    /**
     * Adds an attendee to the specified event.
     * Roles: Host
     */
    @PostMapping(path="/event/{eventid}/attendees")
    public EventAttendees addEventAttendee(EventAttendees attendee, @PathVariable long eventid, HttpServletResponse response) {
    	response.setStatus(HttpServletResponse.SC_CREATED);
    	return eventDao.addEventAttendee(eventid, attendee);
    }
    
//    @DeleteMapping(path="/event/{eventid}/attendees/{userid}")
//    public void removeEventAttendee(HttpServletResponse response) {
//    	// successfully deleted a record
//    	response.setStatus(HttpServletResponse.SC_OK);
//    	// no record to delete
//    	response.setStatus(HttpServletResponse.SC_NO_CONTENT);
//    	// not authorized
//    	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//    }
    
    /**
     * Updates the specified event.
     * Roles: Host
     */
    @PutMapping(path="/event/{eventid}")
    public Event updateEvent(@PathVariable long eventid, Event event, HttpServletResponse response) {
    	return eventDao.updateEvent(eventid, event);
    }
}
