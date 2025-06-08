package edu.lawrence.picker;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins = "*")
public class RestaurantsController {
	
	private RestaurantsDAO dao;
	
	public RestaurantsController(RestaurantsDAO dao) {
		this.dao = dao;
	}
	

	//Gets all the restaurants
	@GetMapping
	public List<Restaurants> getAllRestaurants()
	{
		return dao.getAllRestaurants();
	}
	
	//Gets all restaurants based on the filtered category
	@GetMapping("/{category}")
	public List<Restaurants> getRestaurantsFiltered(@PathVariable String category ){
		return dao.getRestaurantsFiltered(category);
	}
	
	//Gets all the restaurants based on filtered price 
	@GetMapping("/{price}")
	public List<Restaurants> getRestaurantsByPrice(@PathVariable int price){
		return dao.getRestaurantsByPrice(price);
	}
	
	//Gets all the restaurants based on both filtered price and category
	public List<Restaurants> getRestaurantsByBoth(@PathVariable String category, int price){
		return dao.getRestaurantsByBoth(category, price);
	}
	
	//Need the post requests for adding in restaurants
	@PostMapping("/newRestaurant")
	public void addNewRestaurant(@RequestParam Restaurants restaurant) {
		 dao.addNewRestaurant(restaurant);
	}
}
