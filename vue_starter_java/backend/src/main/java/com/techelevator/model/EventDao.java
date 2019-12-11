package com.techelevator.model;

import java.util.List;

public interface EventDao {
	
	public List<Event> getEventsForUser(long userId);
	public Event createEvent(Event event);
	public void deleteEvent(long id);
	public List<EventAttendees> getEventAttendees(long id);
	public EventAttendees addEventAttendee(long id, EventAttendees attendees);
	public Event updateEvent(long id, Event event);
	public Event getEventDetails(long id);
	
	public Address getAddress(long addressID);

}
