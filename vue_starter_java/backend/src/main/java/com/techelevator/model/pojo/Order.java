package com.techelevator.model.pojo;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Order {
	private Long orderId;
	
	@NotNull(message="Event ID needs to be specified")
	@Min(value=0, message="Event ID needs to be a positive number")
	private Long eventId;
	
	// set by User object
	private Long userId;
	
	@NotNull(message="Food ID needs to be specified")
	@Min(value=0, message="Food ID needs to be a positive number")
	private Long foodId;
	
	@NotNull(message="Status needs to be specified")
	private String status;
	
	@NotNull(message="Quantity needs to be specified")
	@Min(value=0, message="Quantity needs to be a positive number")
	private Integer quantity;
	
	@JsonIgnore
	@AssertTrue(message="Status needs to be one of: WAITING, DONE")
	public boolean isStatusValid() {
		return status != null &&
				(status.equalsIgnoreCase("waiting") || status.equalsIgnoreCase("done"));
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

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

	public long getFoodId() {
		return foodId;
	}

	public void setFoodId(long foodId) {
		this.foodId = foodId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
