package com.cg.ems.service;

import java.util.List;

import com.cg.ems.dto.FoodItemsDTO;

public interface FoodItemsService {
	 public FoodItemsDTO addFoodItems(FoodItemsDTO fooditemsDTO);
	  public FoodItemsDTO updateFoodItems(FoodItemsDTO fooditemsDTO);
	  public boolean deleteFoodItems(FoodItemsDTO fooditemsDTO);
	  public FoodItemsDTO getById(int foodId);
	 public List<FoodItemsDTO> findAll();
}
