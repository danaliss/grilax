package com.techelevator.model;

import java.util.List;

public interface EventDao {
	
	public List<Event> getEventsForUser(long userId);
	public Event createEvent();
	public void deleteEvent(long id);
	public List<EventAttendees> getEventAttendees(long id);
	public EventAttendees addEventAttendee(long id);
	public Event updateEvent(long id);
	public Event getEventDetails(long id);

}
