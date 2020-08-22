package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RestaurantService {
   
	@Autowired
	private RestaurantRepository restaurantRepository;
	

	public List<Restaurant> getAll(){
		return restaurantRepository.findAll();
	}
	public Restaurant getByName(String name) {
		return restaurantRepository.findByName(name);
	}
	
}