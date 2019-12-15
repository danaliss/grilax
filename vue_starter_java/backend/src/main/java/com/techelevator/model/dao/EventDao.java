package com.techelevator.model.dao;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.techelevator.model.pojo.Address;
import com.techelevator.model.pojo.Event;
import com.techelevator.model.pojo.EventAttendees;

public interface EventDao {
	
	public List<Event> getEventsForUser(long userId);
	public Event createEvent(Event event, long userID, Address address) throws DataIntegrityViolationException;
	public int deleteEvent(long id);
	public List<EventAttendees> getEventAttendees(long id);
	public EventAttendees addEventAttendee(long id, EventAttendees attendees) throws DataIntegrityViolationException;
	public Event updateEvent(long id, Event event);
	public Event getEventDetails(long id);
	
	public Address getAddress(long addressID);

}