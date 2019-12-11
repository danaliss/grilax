package com.techelevator.model;

import java.util.List;

public interface FoodOrderDao {
	
	public List<Food> getFoodItems(long eventId);
	public Food createFoodItems(Food food);
	public Food updateFoodItems(Food food);
	public void deleteFoodItem(long eventId, long foodId);
	public List<Order> getEventOrders(long eventId);
	public Order createOrder(Order order);
	public Order updateOrder(Order order);
	public void deleteOrder(long eventId, long orderId);
}
