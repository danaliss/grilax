package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.techelevator.model.Event;
import com.techelevator.model.EventAttendees;

public class EventController extends ApiController {
	/**
	 * Gets a list of all the events for the currently logged in user.
	 * Roles: Anonymous
	 * 
	 * @return List of all the events for the user
	 */
    @GetMapping(path="/events")
    public List<Event> getEventsForUser(HttpServletResponse response) {
    	return null;
    }
    
    /**
     * Create cookout
     * Roles: Host
     */
    @PostMapping(path="/events")
    public Event createEvent(HttpServletResponse response) {
    	response.setStatus(HttpServletResponse.SC_CREATED);
    	return null;
    }
    
    /**
     * Views the cookout details for the specified event.
     * Roles: Attendee | Host | Chef
     */
    @GetMapping(path="/event/{eventid}")
    public Event getEventDetails(HttpServletResponse response) {
    	return null;
    }
    
    /**
     * Deletes the specified event.
     * Roles: Host
     */
    @DeleteMapping(path="/event/{eventid}")
    public void deleteEvent(HttpServletResponse response) {
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
    public List<EventAttendees> getEventAttendees(HttpServletResponse response) {
    	return null;
    }
    
    /**
     * Adds an attendee to the specified event.
     * Roles: Host
     */
    @PostMapping(path="/event/{eventid}/attendees")
    public EventAttendees addEventAttendee(HttpServletResponse response) {
    	response.setStatus(HttpServletResponse.SC_CREATED);
    	return null;
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
    public Event updateEvent(HttpServletResponse response) {
    	return null;
    }
}
