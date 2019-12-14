package com.techelevator.model.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Length.List;

public class EventAttendees {
	private long eventId;
	
	@NotNull(message="Invalid user ID")
	private Long userId;
	
	@NotNull(message="Host value needs to be true or false")
	private Boolean isHost;
	
	@NotNull(message="Attending value needs to be true or false")
	private Boolean isAttending;
	
	@NotNull(message="First name must be provided")
	@List({
		@Length(min=1, message="First name must be at least one character"),
		@Length(max=25, message="First name cannot be more than 25 characters")
	})
	private String firstName;
	
	@NotNull(message="Last name must be provided")
	@List({
		@Length(min=1, message="Last name must be at least one character"),
		@Length(max=50, message="Last name cannot be more than 50 characters")
	})
	private String lastName;
	
	@NotNull(message="Adult guest count must be specified")
	@Min(value=0, message="Adult guest count cannot be a negative number")
	private Integer adultGuests;
	
	@NotNull(message="Child guest count must be specified")
	@Min(value=0, message="Child guest count cannot be a negative number")
	private Integer childGuests;

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