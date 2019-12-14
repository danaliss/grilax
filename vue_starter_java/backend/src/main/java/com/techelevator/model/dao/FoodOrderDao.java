package com.techelevator.model.dao;

import java.util.List;

import com.techelevator.model.pojo.Food;
import com.techelevator.model.pojo.Order;

public interface FoodOrderDao {
	
	public List<Food> getFoodItems(long eventId);
	public Food createFoodItems(Food food);
	public Food updateFoodItems(Food food);
	public int deleteFoodItem(long eventId, long foodId);
	public List<Order> getEventOrders(long eventId);
	public Order createOrder(Order order);
	public Order updateOrder(Order order);
	public int deleteOrder(long eventId, long orderId);
}
