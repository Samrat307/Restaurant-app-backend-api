package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String>{
   public Restaurant findByName(String name);
   public List<Restaurant> findAll();
}