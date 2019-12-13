package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcFoodOrderDao implements FoodOrderDao {

	JdbcTemplate jdbc;
	
	@Autowired
	public JdbcFoodOrderDao(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Food> getFoodItems(long eventId) {
		String sqlString = "SELECT food.food_id, food.food_name, food.vegetarian, food.vegan, food.gluten_free, food.nut_free, food.description, food.menu_id "
						 + "FROM food "
						 + "JOIN event USING(menu_id) "
						 + "WHERE event_id = ?";
		
		SqlRowSet results = jdbc.queryForRowSet(sqlString, eventId);
		
		List<Food> foodList = new ArrayList<>();
		while( results.next() ) {
			foodList.add(mapRowToFood(results));
		}
		
		return foodList;
	}

	@Override
	public Food createFoodItems(Food food) {
		String sqlString = "INSERT INTO food (food_id, food_name, vegetarian, vegan, gluten_free, nut_free, description, menu_id) "
						 + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		Food newFood = null;
		int updates = jdbc.update(sqlString, food.getFoodId(), food.getFoodName(), food.isVegetarian(), food.isVegan(), food.isGlutenFree(), food.isNutFree(), food.getDescription(), food.getMenuId());
		
		if( updates > 0 ) {
			newFood = food;
		}
		
		return newFood;
	}

	@Override
	public Food updateFoodItems(Food food) {
		String sqlString = "UPDATE food SET "
						 + "food_name = ?, "
						 + "vegetarian = ?, "
						 + "vegan = ?, "
						 + "gluten_free = ?, "
						 + "nut_free = ?, "
						 + "description = ?, "
						 + "menu_id = ? "
						 + "WHERE food_id = ?";
		
		Food newFood = null;
		int updates = jdbc.update(sqlString, food.getFoodName(), food.isVegetarian(), food.isVegan(), food.isGlutenFree(), food.isNutFree(), food.getDescription(), food.getMenuId(), food.getFoodId());
		
		if( updates > 0 ) {
			newFood = food;
		}
		
		return newFood;
	}

	@Override
	public int deleteFoodItem(long eventId, long foodId) {
		String sqlString = "DELETE FROM food WHERE food_id = ?";
		
		return jdbc.update(sqlString, foodId);
	}

	@Override
	public List<Order> getEventOrders(long eventId) {
		String sqlString = "SELECT order_id, event_id, user_id, food_id, status, quantity FROM orders "
						 + "WHERE event_id = ?";
		
		SqlRowSet results = jdbc.queryForRowSet(sqlString, eventId);
		
		List<Order> orders = new ArrayList<>();
		while( results.next() ) {
			orders.add(mapRowToOrder(results));
		}
		
		return orders;
	}

	@Override
	public Order createOrder(Order order) {
		String sqlString = "INSERT INTO order (order_id, event_id, user_id, food_id, status, quantity)"
						 + " VALUES(?, ?, ?, ?, ?, ?)";
		
		Order newOrder = null;
		int updates = jdbc.update(sqlString, order.getOrderId(), order.getEventId(), order.getUserId(), order.getFoodId(), order.getStatus(), order.getQuantity());
		
		if( updates > 0 ) {
			newOrder = order;
		}
		
		return newOrder;
	}

	@Override
	public Order updateOrder(Order order) {
		String sqlString = "UPDATE order SET "
						 + "event_id = ?, "
						 + "user_id = ?, "
						 + "food_id = ?, "
						 + "status = ?, "
						 + "quantity = ? "
						 + "WHERE order_id = ?";
		
		jdbc.update(sqlString, order.getEventId(), order.getUserId(), order.getFoodId(), order.getStatus(), order.getQuantity(), order.getOrderId());
		
		return order;
	}

	@Override
	public int deleteOrder(long eventId, long orderId) {
		String sqlString = "DELETE FROM order WHERE orderId = ?";
		
		return jdbc.update(sqlString, orderId);
	}
	
	private Food mapRowToFood(SqlRowSet row) {
		Food food = new Food();
		
		food.setFoodId(row.getLong("food_id"));
		food.setFoodName(row.getString("food_name"));
		food.setVegetarian(row.getBoolean("vegetarian"));
		food.setVegan(row.getBoolean("vegan"));
		food.setGlutenFree(row.getBoolean("gluten_free"));
		food.setNutFree(row.getBoolean("nut_free"));
		food.setDescription(row.getString("description"));
		food.setMenuId(row.getLong("menu_id"));
		
		return food;
	}

	private Order mapRowToOrder(SqlRowSet row) {
		Order order = new Order();
		
		order.setOrderId(row.getLong("order_id"));
		order.setEventId(row.getLong("event_id"));
		order.setUserId(row.getLong("user_id"));
		order.setFoodId(row.getLong("food_id"));
		order.setStatus(row.getString("status"));
		order.setQuantity(row.getInt("quantity"));
		
		return order;
	}
}
