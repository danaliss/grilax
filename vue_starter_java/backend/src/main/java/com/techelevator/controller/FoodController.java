package com.techelevator.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class FoodController extends ApiController {
	/**
	 * Views the menu for the specified event.
	 * Roles: Attendee | Host | Chef
	 */
    @GetMapping(path="/event/{eventid}/menu")
    public void getFoodItems() {
    	
    }

    /**
     * Adds a food item to the specified event's menu.
     * Roles: Host
     */
    @PostMapping(path="/event/{eventid}/menu")
    public void createFoodItems() {
    	
    }
    
    /**
     * Updates the specified food item for the specified event.
     * Roles: Host
     */
    @PutMapping(path="/event/{eventid}/menu/{itemid}")
    public void updateFoodItems() {
    	
    }
    
    /**
     * Delete the specified food item from the menu of the specified event.
     * Roles: Host
     */
    @DeleteMapping(path="/event/{eventid}/menu/{itemid}")
    public void deleteFoodItem() {
    	
    }
    
    /**
     * Gets all the submitted orders for the specified event.
     * Roles: Chef
     * 
     * @param all orders, completed orders, incomplete orders
     */
    @GetMapping(path="/event/{eventid}/orders")
    public void getEventOrders() {
    	
    }
    
    /**
     * Place an order for the specified event.
     * Roles: Attendee | Host
     */
    @PostMapping(path="/event/{eventid}/order")
    public void createOrder() {
    	
    }
    
    /**
     * Updates an order for the specified event.
     * Roles: Attendee | Host
     */
    @PutMapping(path="/event/{eventid}/order")
    public void updateOrder() {
    	
    }
    
    /**
     * Deletes an order for the specified event.
     * Roles: Attendee | Host
     */
    @DeleteMapping(path="/event/{eventid}/order/{orderid}")
    public void deleteOrder() {
    	
    }
}
