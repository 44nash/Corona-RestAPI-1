package com.spring.corona_1.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
//Location
import com.spring.corona_1.model.Location;
import com.spring.corona_1.model.LocationFinal;
import com.spring.corona_1.service.LocationFinalService;
import com.spring.corona_1.service.LocationService;
import com.spring.corona_1.service.UserDetailsServiceImpl;


//Location Final NO EDIT DATA
//import com.spring.corona_1.mysql.model.LocationFinal;
//import com.spring.corona_1.mysql.service.LocationFinalService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/location")
public class LocationController {
	
	
	@Autowired
	LocationFinalService locationFinalService;
	
	@Autowired
	LocationService locationService;
	
	@GetMapping("/here")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN') or hasRole('DEV')")
	public String here() {
		return "Here";
		
	}
	
	
	
		// POST  -> creating resources
		//@RequestParam(name="emp_id", required=true)
	  @PostMapping(value="/addMarkerLocation", produces="application/json")
	  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN') or hasRole('DEV')")
	  public String addMarkerLocation(@RequestBody ObjectNode place ) {
		  int num=  place.get("num").asInt();
		  String placeString = place.get("place").asText();
		  Location e = locationService.addLocation(placeString, num);
		  LocationFinal efinal = locationFinalService.addLocation(placeString, num);
		  String message =e.getPlace();
		  System.out.println(message);
		  System.out.println(" was added. nice Job :) !!!");
		  System.out.println();
		  System.out.println( efinal.getPlace() +" FINAL was added. nice Job :) !!!");
		  
		  
		  return message;
	  }
	  
//	  {
//		    "place": "WestOrange",
//		    "num": 2
//		  }
	  
	  
	  
	
	
	
	  
//		// POST  -> creating resources
//	  @PostMapping(value = "/addMarkerLocationFinal")
//	  public void addMarkerLocationFinal(@RequestBody LocationFinal theLocation ) {
//		  
//		  locationFinalService.addLocation(theLocation);
//
//	  }
	  
	  
	  
	  @GetMapping("/getAllMarkers")
	  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN') or hasRole('DEV')")
	  public List<Location> getAllMarkers() {
		 return  locationService.getAllLocations();
	  }
	  
	  
	  @PreAuthorize("hasRole('DEV') or hasRole('USER')")
	  @GetMapping("/getAllFinalMarkers")
	  public List<LocationFinal> getAllFinalMarkers() {
		 return  locationFinalService.getAllLocations();
	  }
	  
	  
	  
	  
	  
	  //locationService.deleteLocations();
	  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN') or hasRole('DEV')")
	  @DeleteMapping("/deleteMarkers")
	    public void delete() {
	    	locationService.deleteLocations();
	    }
	  
	  
	  
	  
	  
	  
	  

	  
	  
	  
}









