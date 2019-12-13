package com.techelevator.integrationtests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Food;
import com.techelevator.model.JdbcFoodOrderDao;
import com.techelevator.model.Order;

public class JdbcFoodOrderDaoIntegrationTest extends DaoIntegrationTest {

	@Test
	public void getFoodItems_returns_food_for_event() {
		String sql = "SELECT COUNT(*) as food_count FROM food WHERE event_id = ?";
		SqlRowSet select = jdbcTemplate.queryForRowSet(sql, testEventId1);
		select.next();

		long expected = select.getLong("food_count");
		long actual = (long) foodOrderDao.getFoodItems(testEventId1).size();

		Assert.assertEquals(expected, actual);

	}

	@Test
	public void food_can_be_created_and_updated() {

		Food testFood = new Food();
		testFood.setFoodName("Test");
		testFood.setVegetarian(false);
		testFood.setVegan(false);
		testFood.setGlutenFree(false);
		testFood.setNutFree(false);
		testFood.setDescription("Test");
		testFood.setEventId(testEventId2);

		foodOrderDao.createFoodItems(testFood);

		Assert.assertNotNull(foodOrderDao.getFoodItems(testEventId2));
		Assert.assertEquals(1, foodOrderDao.getFoodItems(testEventId2).size());

		Assert.assertEquals("Test", testFood.getFoodName());

		testFood.setFoodName("Also a Test");
		foodOrderDao.updateFoodItems(testFood);

		Assert.assertEquals("Also a Test", testFood.getFoodName());

	}

	@Test
	public void deleteFoodItem_deletes_correctly() {
		Assert.assertEquals(2, foodOrderDao.getFoodItems(testEventId1).size());
		foodOrderDao.deleteFoodItem(testEventId1, testFoodId2);

		Assert.assertEquals(1, foodOrderDao.getFoodItems(testEventId1).size());
	}

	@Test
	public void getEventOrders_returns_orders() {
		String sql = "SELECT COUNT(*) as order_count FROM orders " + "WHERE event_id = ?";
		SqlRowSet select = jdbcTemplate.queryForRowSet(sql, testEventId1);
		select.next();

		long expected = select.getLong("order_count");
		long actual = (long) foodOrderDao.getEventOrders(testEventId1).size();

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void orders_can_be_created_and_updated() {
		Order testOrder = new Order();
		testOrder.setEventId(testEventId2);
		testOrder.setUserId(testUserId);
		testOrder.setFoodId(testFoodId1);
		testOrder.setStatus("waiting");
		testOrder.setQuantity(3);

		foodOrderDao.createOrder(testOrder);

		Assert.assertNotNull(foodOrderDao.getEventOrders(testEventId2));
		Assert.assertEquals(1, foodOrderDao.getEventOrders(testEventId2).size());

		testOrder.setStatus("done");
		foodOrderDao.updateOrder(testOrder);
		Assert.assertEquals("done", testOrder.getStatus());
	}

	@Test
	public void deleteOrder() {
		Assert.assertEquals(1, foodOrderDao.getEventOrders(testEventId1).size());
		foodOrderDao.deleteOrder(testEventId1, testOrderId);

		Assert.assertEquals(0, foodOrderDao.getEventOrders(testEventId1).size());
	}

}
