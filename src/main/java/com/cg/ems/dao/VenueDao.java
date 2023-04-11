package com.cg.ems.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ems.entity.Venue;

@Repository
public interface VenueDao extends CrudRepository<Venue, Integer>  {
      
	Iterable<Venue> findAll();
	
}
