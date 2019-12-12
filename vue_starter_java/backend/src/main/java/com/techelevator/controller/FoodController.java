package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Food;
import com.techelevator.model.FoodOrderDao;
import com.techelevator.model.Order;

@RestController
@RequestMapping("/api")
public class FoodController {
	
	@Autowired
	private FoodOrderDao foodOrderDao;
	
	/**
	 * Views the menu for the specified event.
	 * Roles: Attendee | Host | Chef
	 */
    @GetMapping(path="/event/{eventid}/menu")
    public List<Food> getFoodItems(@PathVariable long eventid, HttpServletResponse response) {
    	return foodOrderDao.getFoodItems(eventid);
    }

    /**
     * Adds a food item to the specified event's menu.
     * Roles: Host
     */
    @PostMapping(path="/event/{eventid}/menu")
    public Food createFoodItems(@PathVariable long eventid, Food food, HttpServletResponse response) {
    	response.setStatus(HttpServletResponse.SC_CREATED);
    	return foodOrderDao.createFoodItems(food);
    }
    
    /**
     * Updates the specified food item for the specified event.
     * Roles: Host
     */
    @PutMapping(path="/event/{eventid}/menu/{itemid}")
    public Food updateFoodItems(@PathVariable long eventid, @PathVariable long itemid, Food food, HttpServletResponse response) {
    	return foodOrderDao.updateFoodItems(food);
    }
    
    /**
     * Delete the specified food item from the menu of the specified event.
     * Roles: Host
     */
    @DeleteMapping(path="/event/{eventid}/menu/{itemid}")
    public void deleteFoodItem(@PathVariable long eventid, @PathVariable long itemid, HttpServletResponse response) {
    	// TODO: see if deleted
    	
    	// successfully deleted a record
    	response.setStatus(HttpServletResponse.SC_OK);
    	// no record to delete
    	response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    	// not authorized
    	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
    
    /**
     * Gets all the submitted orders for the specified event.
     * Roles: Chef
     * 
     * @param all orders, completed orders, incomplete orders
     */
    @GetMapping(path="/event/{eventid}/orders")
    public List<Order> getEventOrders(@PathVariable long eventid, HttpServletResponse response) {
    	return foodOrderDao.getEventOrders(eventid);
    }
    
    /**
     * Place an order for the specified event.
     * Roles: Attendee | Host
     */
    @PostMapping(path="/event/{eventid}/order")
    public Order createOrder(@PathVariable long eventid, Order order, HttpServletResponse response) {
    	response.setStatus(HttpServletResponse.SC_CREATED);
    	return foodOrderDao.createOrder(order);
    }
    
    /**
     * Updates an order for the specified event.
     * Roles: Attendee | Host
     */
    @PutMapping(path="/event/{eventid}/order")
    public Order updateOrder(@PathVariable long eventid, Order order, HttpServletResponse response) {
    	return foodOrderDao.updateOrder(order);
    }
    
    /**
     * Deletes an order for the specified event.
     * Roles: Attendee | Host
     */
    @DeleteMapping(path="/event/{eventid}/order/{orderid}")
    public void deleteOrder(@PathVariable long eventid, @PathVariable long orderid, HttpServletResponse response) {
    	foodOrderDao.deleteOrder(eventid, orderid);
    	
    	// successfully deleted a record
    	response.setStatus(HttpServletResponse.SC_OK);
    	// no record to delete
    	response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    	// not authorized
    	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
