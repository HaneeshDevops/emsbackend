package com.cg.ems.dto;

public class FoodItemsDTO {
	private int foodId;
	private String foodName;
	private double itemCost;
	
	
	public FoodItemsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodItemsDTO(String foodName, double itemCost) {
		
		this.foodName = foodName;
		this.itemCost = itemCost;
	}

	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public double getItemCost() {
		return itemCost;
	}
	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}

	@Override
	public String toString() {
		return "FoodItemsDTO [foodId=" + foodId + ", foodName=" + foodName + ", itemCost=" + itemCost + "]";
	}
	
}
