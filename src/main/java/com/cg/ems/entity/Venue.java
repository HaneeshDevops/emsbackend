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
@Table(name="venues")
public class Venue implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int venueId;
	private String venueName;
	private double venueCost;
	private String location;
	private String venueContact;
	@OneToMany(mappedBy="venue")
	private List<Booking> bookingList=new ArrayList<Booking>();
	
	public Venue() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Venue(int venueId, String venueName, double venueCost, String location, String venueContact,
			List<Booking> bookingList) {
		super();
		this.venueId = venueId;
		this.venueName = venueName;
		this.venueCost = venueCost;
		this.location = location;
		this.venueContact = venueContact;
		this.bookingList = bookingList;
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
	public List<Booking> getBookingList() {
		return bookingList;
	}
	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Venue [venueId=" + venueId + ", venueName=" + venueName + ", venueCost=" + venueCost + ", location="
				+ location + ", venueContact=" + venueContact + ", bookingList=" + bookingList + "]";
	}
	
}