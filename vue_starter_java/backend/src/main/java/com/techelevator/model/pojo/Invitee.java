package com.techelevator.model.pojo;

public class Invitee {

	private long inviteId;
	private String email;
	private int eventId;
	private String role;
	
	public long getInviteId() {
		return inviteId;
	}
	public void setInviteId(long inviteId) {
		this.inviteId = inviteId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
