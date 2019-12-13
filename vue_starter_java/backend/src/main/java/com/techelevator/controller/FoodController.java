package com.techelevator.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.controller.response.Response;
import com.techelevator.controller.response.ResponseError;
import com.techelevator.model.Food;
import com.techelevator.model.FoodOrderDao;
import com.techelevator.model.Order;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class FoodController {
	
	@Autowired
	private FoodOrderDao foodOrderDao;
	
	/**
	 * Views the menu for the specified event.
	 * Roles: Attendee | Host | Chef
	 */
    @GetMapping(path="/event/{eventid}/menu")
    public Response getFoodItems(@PathVariable long eventid, HttpServletResponse response) {
    	return new Response(foodOrderDao.getFoodItems(eventid));
    }

    /**
     * Adds a food item to the specified event's menu.
     * Roles: Host
     */
    @PostMapping(path="/event/{eventid}/menu")
    public Response createFoodItems(@PathVariable long eventid, Food food, HttpServletResponse response) {
    	Food newFood = foodOrderDao.createFoodItems(food);
    	
    	if( newFood != null ) {
	    	response.setStatus(HttpServletResponse.SC_CREATED);
	    	return new Response(newFood);
    	} else {
    		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return new Response(new ResponseError("Unable to create food item"));
    	}
    }
    
    /**
     * Updates the specified food item for the specified event.
     * Roles: Host
     */
    @PutMapping(path="/event/{eventid}/menu/{itemid}")
    public Response updateFoodItems(@PathVariable long eventid, @PathVariable long itemid, Food food, HttpServletResponse response) {
    	Food newFood = foodOrderDao.updateFoodItems(food);
    	
    	if( newFood != null ) {
    		return new Response(newFood);
    	} else {
    		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return new Response(new ResponseError("Unable to update menu item"));
    	}
    }
    
    /**
     * Delete the specified food item from the menu of the specified event.
     * Roles: Host
     */
    @DeleteMapping(path="/event/{eventid}/menu/{itemid}")
    public Response deleteFoodItem(@PathVariable long eventid, @PathVariable long itemid, HttpServletResponse response) {
    	// TODO: return food object that was deleted?
    	int deleted = foodOrderDao.deleteFoodItem(eventid, itemid);
    	
    	if( deleted > 0 ) {
	    	// successfully deleted a record
	    	response.setStatus(HttpServletResponse.SC_OK);
	    	return new Response();
    	} else {
	    	// no record to delete
	    	response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	    	return new Response(new ResponseError("Food item not found"));
    	}
    	// TODO
    	// not authorized
    	//response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
    
    /**
     * Gets all the submitted orders for the specified event.
     * Roles: Chef
     * 
     * @param all orders, completed orders, incomplete orders
     */
    @GetMapping(path="/event/{eventid}/orders")
    public Response getEventOrders(@PathVariable long eventid, HttpServletResponse response) {
    	return new Response(foodOrderDao.getEventOrders(eventid));
    }
    
    /**
     * Place an order for the specified event.
     * Roles: Attendee | Host
     */
    @PostMapping(path="/event/{eventid}/order")
    public Response createOrder(@PathVariable long eventid, Order order, HttpServletResponse response) {
    	Order newOrder = foodOrderDao.createOrder(order);
    	
    	if( newOrder != null ) {
	    	response.setStatus(HttpServletResponse.SC_CREATED);
	    	return new Response(newOrder);
    	} else {
    		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return new Response(new ResponseError("Unable to create order"));
    	}
    }
    
    /**
     * Updates an order for the specified event.
     * Roles: Attendee | Host
     */
    @PutMapping(path="/event/{eventid}/order")
    public Response updateOrder(@PathVariable long eventid, Order order, HttpServletResponse response) {
    	Order newOrder = foodOrderDao.updateOrder(order);
    	
    	if( newOrder != null ) {
    		return new Response();
    	} else {
    		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		return new Response(new ResponseError("Bad event update"));
    	}
    }
    
    /**
     * Deletes an order for the specified event.
     * Roles: Attendee | Host
     */
    @DeleteMapping(path="/event/{eventid}/order/{orderid}")
    public Response deleteOrder(@PathVariable long eventid, @PathVariable long orderid, HttpServletResponse response) {
    	int updates = foodOrderDao.deleteOrder(eventid, orderid);
    	
    	if( updates > 0 ) {
	    	// successfully deleted a record
	    	response.setStatus(HttpServletResponse.SC_OK);
	    	return new Response();
    	} else {
	    	// no record to delete
	    	response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	    	return new Response(new ResponseError("Unable to delete event"));
    	}
    	// not authorized
    	// TODO
    	//response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
