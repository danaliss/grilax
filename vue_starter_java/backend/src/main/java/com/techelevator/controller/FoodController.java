package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.techelevator.model.Food;
import com.techelevator.model.Order;

public class FoodController extends ApiController {
	/**
	 * Views the menu for the specified event.
	 * Roles: Attendee | Host | Chef
	 */
    @GetMapping(path="/event/{eventid}/menu")
    public List<Food> getFoodItems(HttpServletResponse response) {
    	return null;
    }

    /**
     * Adds a food item to the specified event's menu.
     * Roles: Host
     */
    @PostMapping(path="/event/{eventid}/menu")
    public Food createFoodItems(HttpServletResponse response) {
    	response.setStatus(HttpServletResponse.SC_CREATED);
    	return null;
    }
    
    /**
     * Updates the specified food item for the specified event.
     * Roles: Host
     */
    @PutMapping(path="/event/{eventid}/menu/{itemid}")
    public Food updateFoodItems(HttpServletResponse response) {
    	return null;
    }
    
    /**
     * Delete the specified food item from the menu of the specified event.
     * Roles: Host
     */
    @DeleteMapping(path="/event/{eventid}/menu/{itemid}")
    public void deleteFoodItem(HttpServletResponse response) {
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
    public List<Order> getEventOrders(HttpServletResponse response) {
    	return null;
    }
    
    /**
     * Place an order for the specified event.
     * Roles: Attendee | Host
     */
    @PostMapping(path="/event/{eventid}/order")
    public Order createOrder(HttpServletResponse response) {
    	response.setStatus(HttpServletResponse.SC_CREATED);
    	return null;
    }
    
    /**
     * Updates an order for the specified event.
     * Roles: Attendee | Host
     */
    @PutMapping(path="/event/{eventid}/order")
    public Order updateOrder(HttpServletResponse response) {
    	return null;
    }
    
    /**
     * Deletes an order for the specified event.
     * Roles: Attendee | Host
     */
    @DeleteMapping(path="/event/{eventid}/order/{orderid}")
    public void deleteOrder(HttpServletResponse response) {
    	// successfully deleted a record
    	response.setStatus(HttpServletResponse.SC_OK);
    	// no record to delete
    	response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    	// not authorized
    	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
