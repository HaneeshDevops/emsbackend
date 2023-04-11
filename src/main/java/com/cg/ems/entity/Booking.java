package com.cg.ems.entity;

import java.io.Serializable;
import java.util.Date;

import com.cg.ems.entity.Event;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	private Date date;
	private String totalHour;
	private double totalCost;
	private int noOfGuest;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id")
	private Event event;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "venue_id")
	private Venue venue;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "food_id")
	private FoodItems foodItems;
	@OneToOne(mappedBy = "booking")

	private Payment payment;
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_name")
//	private User user;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(int bookingId, Date date, String totalHour, double totalCost, int noOfGuest, Event event,
			Venue venue, FoodItems foodItems, Payment payment) {
		super();
		this.bookingId = bookingId;
		this.date = date;
		this.totalHour = totalHour;
		this.totalCost = totalCost;
		this.noOfGuest = noOfGuest;
		this.event = event;
		this.venue = venue;
		this.foodItems = foodItems;
		this.payment = payment;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTotalHour() {
		return totalHour;
	}

	public void setTotalHour(String totalHour) {
		this.totalHour = totalHour;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public int getNoOfGuest() {
		return noOfGuest;
	}

	public void setNoOfGuest(int noOfGuest) {
		this.noOfGuest = noOfGuest;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public FoodItems getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(FoodItems foodItems) {
		this.foodItems = foodItems;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", date=" + date + ", totalHour=" + totalHour + ", totalCost="
				+ totalCost + ", noOfGuest=" + noOfGuest + ", event=" + event + ", venue=" + venue + ", foodItems="
				+ foodItems + ", payment=" + payment + "]";
	}

}
