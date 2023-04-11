package com.cg.ems.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ems.entity.FoodItems;
@Repository
public interface FoodItemsDao extends CrudRepository<FoodItems,Integer>{

}
