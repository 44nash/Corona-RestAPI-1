package com.spring.corona_1.repo;


import java.sql.Date;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.corona_1.model.Location;

@Repository
public interface LocationRepository  extends JpaRepository<Location, Integer> {
	
	
//		@Modifying
//	@Query("delete from Book b where b.title=:title")
//	void deleteBooks(@Param("title") String title);
	

	//@Query("delete from locations where killdate < NOW()")
	///void deleteIfTimesUp();

//	void addLocation(Location theLocation);
//
//	List<Location> getAllLocations();
	
	
	
	//SELECT * FROM table WHERE date_column >= '2014-01-01' AND date_column <= '2015-01-01';

	
	@Modifying
	@Query(value ="DELETE  FROM location where killdate <= curdate()" , nativeQuery = true)
	@Transactional()
	public void findByListOfMarksToDelete();
	
	
}