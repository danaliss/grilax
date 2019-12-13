package com.techelevator.model;

import java.util.List;

public interface EventDao {
	
	public List<Event> getEventsForUser(long userId);
	public Event createEvent(Event event);
	public List<EventAttendees> getEventAttendees(long id);
	public EventAttendees addEventAttendee(EventAttendees attendees);
	public Event updateEvent(long id, Event event);
	public Event getEventDetails(long id);
	
	public Address getAddress(long addressID);
	public Address addAddress(Address address);

}
