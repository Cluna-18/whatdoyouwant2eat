package edu.lawrence.picker;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	//Get a RestaurantName given an ID
	
	//Get all restaurants
	public List<Restaurants> getAllRestaurants(){
		String sql = "SELECT * FROM restaurants";
		return jdbcTemplate.query(sql, new RestaurantsRowMapper());
	}
	
	//Get restaurants based on filter
	public List<Restaurants> getRestaurantsFiltered(String category){
		String sql = "SELECT * FROM restaurants WHERE category=?";
		return jdbcTemplate.query(sql, new RestaurantsRowMapper(), category);
	}
	// Get restaurant by its filtered price
	public List<Restaurants> getRestaurantsByPrice(int price){
		String sql = "SELECT * FROM restaurants WHERE price=?";
		return jdbcTemplate.query(sql, new RestaurantsRowMapper(), price);
	}
	//Get a restaurant by both the price and the category filtered
	public List<Restaurants> getRestaurantsByBoth(String category, int price){
		String sql = "SELECT * FROM restaurants WHERE price = ? AND category = ?";
		return jdbcTemplate.query(sql,  new RestaurantsRowMapper(), category,price);
	}
	
	//Post a new restaurant to the database
	public void addNewRestaurant(Restaurants restaurant) {
		String restaurantId = UUID.randomUUID().toString();
		String sql = "INSERT INTO restaurants (restaurantId, name, category, price, knownFor, specificFood) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sql,restaurantId,restaurant.getName(),restaurant.getCategory(), restaurant.getPrice(), restaurant.getKnownFor(),restaurant.getSpecificFood());
	}
	
	//
}