package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.authentication.RequestAuthProvider;
import com.techelevator.controller.response.Response;
import com.techelevator.controller.response.ResponseError;
import com.techelevator.controller.response.ValidationError;
import com.techelevator.model.dao.EventDao;
import com.techelevator.model.pojo.Address;
import com.techelevator.model.pojo.Event;
import com.techelevator.model.pojo.EventAttendees;
import com.techelevator.model.pojo.User;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class EventController {
	
	@Autowired
	private EventDao eventDao;
	
	/**
	 * Gets the address by the ID
	 * 
	 * @param addressid the ID of the address
	 * @return Address object for the specified ID
	 */
	@GetMapping(path="/address/{addressid}")
	public Response<?> getAddressByID(@PathVariable long addressid) {
		Address address = eventDao.getAddress(addressid);
		
		if( address != null ) {
			return new Response<>(address);
		} else {
			return new Response<>(new ResponseError("Invalid address"));
		}
	}
	
	/**
	 * Gets a list of all the events for the currently logged in user.
	 * Roles: Anonymous
	 * 
	 * @param request HTTP request object
	 * @deprecated @param response HTTP response object
	 * @return List of all the events for the user
	 */
    @GetMapping(path="/events")
    public Response<?> getEventsForUser(HttpServletRequest request, HttpServletResponse response) {
    	User user = (User)request.getAttribute(RequestAuthProvider.USER_KEY);
    	
    	if( user == null ) {
    		return new Response<>(new ResponseError("Unknown User"));
    	}
    	
    	return new Response<>(eventDao.getEventsForUser(user.getId()));
    }
    
    /**
     * Create cookout
     * Roles: Host
     * 
     * @param event Event object to create
     * @param response HTTP response object
     * @return new event object
     * <strong>HTTP 201</strong> Created
     * <strong>HTTP 400</strong> Bad request
     */
    @PostMapping(path="/events")
    public Response<?> createEvent(@Valid @RequestBody Event event, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
    	User user = (User)request.getAttribute(RequestAuthProvider.USER_KEY);
    	
    	if( user == null ) {
    		return new Response<>(new ResponseError("Unknown User"));
    	}
    	
    	if( result.hasErrors() ) {
        	// Form validation failed
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return new Response<>(ValidationError.createList(result));
    	}
    	
    	Event newEvent = null;
    	DataIntegrityViolationException error = null;
		try {
			newEvent = eventDao.createEvent(event, user.getId());
		} catch (DataIntegrityViolationException e) {
			error = e;
		}
    	if( newEvent != null ) {
    		response.setStatus(HttpServletResponse.SC_CREATED);
        	return new Response<>(newEvent);
    	} else {
    		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return new Response<>(ValidationError.createList(error));
    	}
    }
    
    /**
     * Views the cookout details for the specified event.
     * Roles: Attendee | Host | Chef
     */
    @GetMapping(path="/event/{eventid}")
    public Response<?> getEventDetails(@PathVariable long eventid, HttpServletResponse response) {
    	Event event = eventDao.getEventDetails(eventid);
    	
    	if( event == null ) {
    		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return new Response<>(new ResponseError("Event not found"));
    	}
    	
    	return new Response<>(event);
    }
    
    /**
     * Deletes the specified event.
     * Roles: Host
     */
    @DeleteMapping(path="/event/{eventid}")
    public Response<?> deleteEvent(@PathVariable long eventid, HttpServletResponse response) {
    	// TODO: return event object that was deleted?
    	int deletions = eventDao.deleteEvent(eventid);
    	
    	if( deletions > 0 ) {
        	// successfully deleted a record
    		response.setStatus(HttpServletResponse.SC_OK);
    		return new Response<>();
    	} else {
	    	// no record to delete
	    	response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	    	return new Response<>(new ResponseError("Event not found"));
    	}
    	// not authorized
    	// TODO
    	// response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
    
    /**
     * Gets the attendees from the specified event.
     * Roles: Attendees | Host
     */
    @GetMapping(path="/event/{eventid}/attendees")
    public Response<?> getEventAttendees(@PathVariable long eventid, 
                                        HttpServletRequest request, 
                                        HttpServletResponse response) {
        User user = (User)request.getAttribute(RequestAuthProvider.USER_KEY);
        
        List<EventAttendees> attendees = eventDao.getEventAttendees(eventid, user.getId());
        
        return new Response<>(attendees);
    }

    
    /**
     * Adds an attendee to the specified event.
     * Roles: Host
     */
    @PostMapping(path="/event/{eventid}/attendees")
    public Response<?> addEventAttendee(@Valid @RequestBody EventAttendees attendee, @PathVariable long eventid, BindingResult result, HttpServletResponse response) {
    	if( result.hasErrors() ) {
    		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return new Response<>(ValidationError.createList(result));
    	}
    	EventAttendees newEventAttendees = null;
    	try {
    		newEventAttendees = eventDao.addEventAttendee(eventid, attendee);
    	} catch(DataIntegrityViolationException e) {
    		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return new Response<>(ValidationError.createList(e));
    	}
    	if( newEventAttendees == null ) {
    		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return new Response<>(new ResponseError("Failed to add new attendee"));
    	}
    	response.setStatus(HttpServletResponse.SC_CREATED);
    	return new Response<>(eventDao.addEventAttendee(eventid, attendee));
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
    public Response<?> updateEvent(@PathVariable long eventid, Event event, HttpServletResponse response) {
    	return new Response<>(eventDao.updateEvent(eventid, event));
    }
}