package edu.lawrence.picker;

public class Restaurants {
	private String Id;
	private String name;
	private String category;
	private int price;
	private String knownFor;
	private String specificFood;
	private String code;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getKnownFor() {
		return knownFor;
	}
	public void setKnownFor(String knownFor) {
		this.knownFor = knownFor;
	}
	public String getSpecificFood() {
		return specificFood;
	}
	public void setSpecificFood(String specificFood) {
		this.specificFood = specificFood;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}


