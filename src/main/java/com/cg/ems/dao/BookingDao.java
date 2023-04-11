package com.cg.ems.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ems.dto.BookingDTO;
import com.cg.ems.entity.Booking;

@Repository

	public interface BookingDao extends CrudRepository<Booking,Integer> {
 
}
