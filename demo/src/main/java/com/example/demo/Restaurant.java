package com.example.demo;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "docs")

public class Restaurant {

	@Id
	public String id;

    public String restaurantId;
	public String name;
	public String imageUrl;
	public Double latitude;
	public Double longitude;
	public List<String> attributes;
	public String opensAt;
	public String closesAt;

	public Restaurant() {}

	public Restaurant(String restaurantId, String name, String imageUrl, 
		Double latitude, Double longitude, List<String> attributes, String opensAt, String closesAt ) {
		this.restaurantId = restaurantId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.latitude = latitude;
		this.longitude = longitude;
		this.attributes = attributes;
		this.opensAt = opensAt;
		this.closesAt = closesAt;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

    public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	} 

}

