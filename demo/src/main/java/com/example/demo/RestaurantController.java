package com.example.demo;

import java.util.*;
import java.lang.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	

	
	@RequestMapping("/get")
	public Restaurant getRestaurant(@RequestParam String name) {
		return restaurantService.getByName(name);
	}
	@RequestMapping("/getAll")
	public List<Restaurant> getAll(){
		return restaurantService.getAll();
	}
  
   	@RequestMapping("/find") 
   	public RestaurantUtil find(@RequestParam(value= "lat") Double latitude,
   	 @RequestParam(value="lng") Double longitude)	{

   	    // Comparator<RestaurantUtil> restComparator = new Comparator<RestaurantUtil>() {
        //     @Override
        //     public int compare(RestaurantUtil r1, RestaurantUtil r2) {
        //         return r1.getDistance()<r2.getDistance();
        //     }
        // };

       List<Restaurant> restaurants = restaurantService.getAll();
        
       // PriorityQueue<RestaurantUtil> pq = 
       // 		new PriorityQueue<RestaurantUtil>(restaurants.size(), restComparator);

       Double smallestDistance = Double.MAX_VALUE;
       Restaurant nearestRestaurant = null;

       for(Restaurant r : restaurants)	{

             Double lat = r.getLatitude();
             Double lon = r.getLongitude();
             Double distance = findDistance(latitude,longitude,lat,lon);
             
             if (smallestDistance > distance){

                 nearestRestaurant = r;

                 }
           }

           RestaurantUtil restaurant = new RestaurantUtil(smallestDistance, nearestRestaurant);
           return restaurant;
   	  }


Double findDistance(Double lat1, Double lng1, Double lat2, Double lng2) {
	lng1 = Math.toRadians(lng1); 
    lng2 = Math.toRadians(lng2); 
    lat1 = Math.toRadians(lat1); 
    lat2 = Math.toRadians(lat2); 
  
    // Haversine formula  
    Double dlng = lng2 - lng1;  
    Double dlat = lat2 - lat1; 
    Double a = Math.pow(Math.sin(dlat / 2), 2) 
                 + Math.cos(lat1) * Math.cos(lat2) 
                 * Math.pow(Math.sin(dlng / 2),2); 
              
   Double c = 2 * Math.asin(Math.sqrt(a)); 
  
    // Radius of earth in kilometers. Use 3956  
    // for miles 
    Double r = 6371.0; 
  
    // calculate the result 
    return (c * r); 
}

}
/**
* Utility function to sort restaurant according to current location.
*/
 class RestaurantUtil {
	Double distance;
    // Restaurant r;
    String restaurant_name;

    public Double getDistance() {
    	return distance;
    }
    public String getRestaurant_name(){
    	return restaurant_name;
    }
    // public Restaurant getRestaurant() {
    // 	return r;
    // }

    public RestaurantUtil(Double distance, Restaurant r) {
    	this.distance = distance;
    	// this.r = r;
    	this.restaurant_name=r.getName();
    }

//     public void display()
// {
//   System.out.println("Minimum distance:"+distance+"Restaurant Name:"+r.getName());
// }
}
    
