package com.techelevator.model;

public class EventAttendees {

	private long eventId;
	private long userId;
	private boolean isHost;
	private boolean isAttending;
	private String firstName;
	private String lastName;
	private int adultGuests;
	private int childGuests;

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public boolean isHost() {
		return isHost;
	}

	public void setHost(boolean isHost) {
		this.isHost = isHost;
	}

	public boolean isAttending() {
		return isAttending;
	}

	public void setAttending(boolean isAttending) {
		this.isAttending = isAttending;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAdultGuests() {
		return adultGuests;
	}

	public void setAdultGuests(int adultGuests) {
		this.adultGuests = adultGuests;
	}

	public int getChildGuests() {
		return childGuests;
	}

	public void setChildGuests(int childGuests) {
		this.childGuests = childGuests;
	}

}
