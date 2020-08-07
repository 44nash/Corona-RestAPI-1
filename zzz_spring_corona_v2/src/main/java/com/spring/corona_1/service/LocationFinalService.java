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
import com.spring.corona_1.model.LocationFinal;
import com.spring.corona_1.repo.LocationFinalRepository;
import com.spring.corona_1.repo.LocationRepository;

@Service
public class LocationFinalService {



	@Autowired
	LocationFinalRepository locationFinal;



	//Add location Here
	public LocationFinal addLocation(String place, int color)
	{		
		
		//Date NOW
		Date renderdate = new Date(new java.util.Date().getTime());
		Date  killdate = addDays(renderdate, 0);
		//Date latere
		
		
		LocationFinal e  = new LocationFinal ( place, renderdate , killdate, color);
		
		
		LocationFinal _Location = locationFinal.save(e);
		return _Location;
	}

	
	public List<LocationFinal> getAllLocations() {
		
		System.out.println("Get all locations final...");

		List<LocationFinal> locationsfinal = new ArrayList<>();
		locationFinal.findAll().forEach(locationsfinal::add);

		return locationsfinal;
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
