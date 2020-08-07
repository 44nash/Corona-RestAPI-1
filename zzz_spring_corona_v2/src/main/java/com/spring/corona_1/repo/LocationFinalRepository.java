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
import com.spring.corona_1.model.LocationFinal;

@Repository
public interface LocationFinalRepository  extends JpaRepository<LocationFinal, Integer> {

	
	
}