package com.cg.ems.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class VenueDTO {
	 @Min(value=1, message="Venue ID must be greater than or equal to 1")
	public int venueId;
	@NotBlank(message = "The name should not be blank")
	@Size(min = 3, max = 100)
	public String venueName;
	@DecimalMin(value = "0.0", inclusive = false, message = "Venue cost must be greater than or equal to 1")
	public double venueCost;
	@NotBlank(message = "Location is required")
	public String location;
	@NotBlank(message = "The email could not be blank or empty or null")
	@Email(message = "Please enter the vaild email id", regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9.]{2,5}")
	public String venueContact;

	public VenueDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VenueDTO(String venueName, double venueCost, String location, String venueContact) {
		super();
		this.venueName = venueName;
		this.venueCost = venueCost;
		this.location = location;
		this.venueContact = venueContact;
	}

	public int getVenueId() {
		return venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public double getVenueCost() {
		return venueCost;
	}

	public void setVenueCost(double venueCost) {
		this.venueCost = venueCost;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getVenueContact() {
		return venueContact;
	}

	public void setVenueContact(String venueContact) {
		this.venueContact = venueContact;
	}

	@Override
	public String toString() {
		return "VenueDTO [venueId=" + venueId + ", venueName=" + venueName + ", venueCost=" + venueCost + ", location="
				+ location + ", venueContact=" + venueContact + "]";
	}

}
