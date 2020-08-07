package com.spring.corona_1.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.corona_1.model.Location;
import com.spring.corona_1.repo.LocationRepository;

@Service
public class LocationService {



	@Autowired
	LocationRepository location;



	//Add location Here
	public Location addLocation(String place, int color)
	{		
		
		//Date NOW
		Date renderdate = new Date(new java.util.Date().getTime());
		Date  killdate = addDays(renderdate, 7);
		//Date latere
		
		
		Location e  = new Location ( place, renderdate , killdate, color);
		
		
		Location _Location = location.save(e);
		return _Location;
	}


	
	
	
	
	//Delete location Here
	//Deleteing from location data base based on time 
	// NOT based of the location
	//CHECK ME LATER
	public void deleteLocations()
	{		
		System.out.println("Deleteing...");
		location.findByListOfMarksToDelete();
		
	}


	
	
	
	public List<Location> getAllLocations() {
		
		System.out.println("Get all locations...");

		List<Location> locations = new ArrayList<>();
		location.findAll().forEach(locations::add);

		return locations;
	}






    private static Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return new Date(c.getTimeInMillis());
    }





    
    
    
    
//    public void testdelete() 
//    {
//    	
//    	EntityManagerFactory emf=Persistence.createEntityManagerFactory(null);
//    	EntityManager em=emf.createEntityManager();
//    	try{
//    	javax.persistence.Query query = em.createQuery("DELETE  FROM location where killdate <= curdate()");
//
//    	int noOf_delete_record = query.executeUpdate();
//    	System.out.println(noOf_delete_record+" record is deleted");
//    	}
//    	finally{
//    	em.close();
//    	}
//    	
//    	
//    	
//    }



}
