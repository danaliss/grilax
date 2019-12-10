package com.techelevator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.techelevator.model.Event;

public class EventController extends ApiController {
	/**
	 * Gets a list of all the events for the currently logged in user.
	 * Roles: Anonymous
	 * 
	 * @return List of all the events for the user
	 */
    @GetMapping(path="/events")
    public List<Event> getEventsForUser() {
    	return null;
    }
    
    /**
     * Create cookout
     * Roles: Host
     */
    @PostMapping(path="/events")
    public void createEvent() {
    	
    }
    
    /**
     * Views the cookout details for the specified event.
     * Roles: Attendee | Host | Chef
     */
    @GetMapping(path="/event/{eventid}")
    public void getEventDetails() {
    	
    }
    
    /**
     * Deletes the specified event.
     * Roles: Host
     */
    @DeleteMapping(path="/event/{eventid}")
    public void deleteEvent() {
    	
    }
    
    /**
     * Gets the attendees from the specified event.
     * Roles: Attendees | Host
     */
    @GetMapping(path="/event/{eventid}/attendees")
    public void getEventAttendees() {
    	
    }
    
    /**
     * Adds an attendee to the specified event.
     * Roles: Host
     */
    @PostMapping(path="/event/{eventid}/attendees")
    public void addEventAttendee() {
    	
    }
    
//    @DeleteMapping(path="/event/{eventid}/attendees/{userid}")
//    public void removeEventAttendee() {
//    	
//    }
    
    /**
     * Updates the specified event.
     * Roles: Host
     */
    @PutMapping(path="/event/{eventid}")
    public void updateEvent() {
    	
    }
}
