package com.techelevator.model;

import java.util.List;

public interface FoodOrderDao {
	
	public List<Food> getFoodItems(long eventId);
	public Food createFoodItems(long eventId);
	public Food updateFoodItems(long eventId, long foodId);
	public void deleteFoodItem(long eventId, long foodId);
	public List<Order> getEventOrders(long eventId);
	public Order createOrder(long eventId);
	public Order updateOrder(long eventId);
	public void deleteOrder(long eventId, long orderId);
}
