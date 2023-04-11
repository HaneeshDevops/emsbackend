package com.cg.ems.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ems.entity.Event;

@Repository
public interface EventDao extends CrudRepository<Event, Integer> {

}
