package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.techelevator.model.Event;
import com.techelevator.model.EventAttendees;
import com.techelevator.model.EventDao;

public class EventController extends ApiController {
	
	@Autowired
	private EventDao eventDao;
	
	/**
	 * Gets a list of all the events for the currently logged in user.
	 * Roles: Anonymous
	 * 
	 * @return List of all the events for the user
	 */
    @GetMapping(path="/events")
    public List<Event> getEventsForUser(HttpServletResponse response) {
    	// TODO: Get that user ID
    	
    	return null;
    }
    
    /**
     * Create cookout
     * Roles: Host
     */
    @PostMapping(path="/events")
    public Event createEvent(Event event, HttpServletResponse response) {
    	response.setStatus(HttpServletResponse.SC_CREATED);
    	return eventDao.createEvent(event);
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
    public Event updateEvent(@PathVariable long eventid, HttpServletResponse response) {
    	return eventDao.updateEvent(eventid);
    }
}
