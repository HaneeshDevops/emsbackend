package com.cg.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.dto.FoodItemsDTO;
import com.cg.ems.service.FoodItemsService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/fooditems")
public class FoodItemsController {
	@Autowired
	public FoodItemsService fooditemsService;

	@PostMapping("/addFoodItems")
	public ResponseEntity<FoodItemsDTO> addFoodItems(@RequestBody FoodItemsDTO fooditemsDTO) {
		FoodItemsDTO fooditems = fooditemsService.addFoodItems(fooditemsDTO);
		return ResponseEntity.ok(fooditems);
	}

	@GetMapping("/fetchFoodItemsById/{id}")
	public ResponseEntity<FoodItemsDTO> getVenueById(@PathVariable int id) {
		FoodItemsDTO fooditemsDTO = fooditemsService.getById(id);
		return new ResponseEntity<FoodItemsDTO>(fooditemsDTO, HttpStatus.FOUND);
	}

	@PutMapping("/updateFoodItems")
	public ResponseEntity<FoodItemsDTO> updateFoodItems(@RequestBody FoodItemsDTO fooditemsDTO) {
		return new ResponseEntity<FoodItemsDTO>(fooditemsService.updateFoodItems(fooditemsDTO), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteFoodItems/{foodId}")
	public ResponseEntity<Boolean> deleteFoodItemsById(@PathVariable int foodId) {
		FoodItemsDTO fooditemsDTO = fooditemsService.getById(foodId);
		if (fooditemsDTO != null)
			fooditemsService.deleteFoodItems(fooditemsDTO);
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
	}
	// throw new VenueNotAvailableException();

	@GetMapping("/fetchAllFoodItems")
	public ResponseEntity<List<FoodItemsDTO>> getAllFoodItems() {
		List<FoodItemsDTO> list = fooditemsService.findAll();
		return ResponseEntity.ok(list);
	}
}
