package com.cg.ems.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.FoodItemsDao;
import com.cg.ems.dto.FoodItemsDTO;
import com.cg.ems.entity.FoodItems;
import com.cg.ems.service.FoodItemsService;
@Service
public class FoodItemsServiceImpl implements FoodItemsService {
	@Autowired
	 private FoodItemsDao fooditemsdao;
	
	@Override
	public FoodItemsDTO addFoodItems(FoodItemsDTO fooditemsDTO) {
		// TODO Auto-generated method stub
		FoodItems fooditems= new FoodItems();
		 BeanUtils.copyProperties(fooditemsDTO, fooditems);
		 FoodItems fooditemssave=fooditemsdao.save(fooditems);
		fooditemsDTO.setFoodId(fooditemssave.getFoodId());
//		 fooditemsdao.save(fooditems);
		 return fooditemsDTO;
	}

	@Override
	public FoodItemsDTO updateFoodItems(FoodItemsDTO fooditemsDTO) {
		// TODO Auto-generated method stub
		FoodItems fooditems=new FoodItems();
		fooditems.setFoodId(fooditemsDTO.getFoodId());
		BeanUtils.copyProperties(fooditemsDTO, fooditems);
		fooditemsdao.save(fooditems);
		return fooditemsDTO;
	}

	@Override
	public boolean deleteFoodItems(FoodItemsDTO fooditemsDTO) {
		// TODO Auto-generated method stub
		FoodItems fooditems=new FoodItems();
		 BeanUtils.copyProperties(fooditemsDTO, fooditems);
		 fooditemsdao.delete(fooditems);
		 return true;
		
	}

	

	@Override
	public List<FoodItemsDTO> findAll() {
		// TODO Auto-generated method stub
		 Iterable<FoodItems> list = fooditemsdao.findAll();
		  List<FoodItemsDTO> dtos=new ArrayList<>();
		 for(FoodItems fooditems:list) {
		  FoodItemsDTO dto=new FoodItemsDTO();
		  BeanUtils.copyProperties(fooditems, dto);
		  dtos.add(dto);
		  }
         return dtos;
}
	

	@Override
	public FoodItemsDTO getById(int foodId) {
		// TODO Auto-generated method stub
		 Optional<FoodItems> fooditems=fooditemsdao.findById(foodId);
		  if(fooditems.isPresent()) {
		 FoodItemsDTO DTO=new FoodItemsDTO();
		  BeanUtils.copyProperties(fooditems.get(), DTO);
		 }
		  return null;
	}
		//throw new VenueNotAvailableException("The user with id "+id+" does not exists");   return null;}
	
}
