package com.cg.ems.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="foodItems")
public class FoodItems implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int foodId;
	public String foodName;
	public double itemCost;
	@OneToMany(mappedBy="foodItems")
	public List<Booking> bookingList=new ArrayList<Booking>();
	public FoodItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodItems(String foodName, double itemCost, List<Booking> bookingList) {
		super();
		this.foodName = foodName;
		this.itemCost = itemCost;
		this.bookingList = bookingList;
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
	public List<Booking> getBookingList() {
		return bookingList;
	}
	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}
	@Override
	public String toString() {
		return "FoodItems [foodId=" + foodId + ", foodName=" + foodName + ", itemCost=" + itemCost + ", bookingList="
				+ bookingList + "]";
	}
	
}
