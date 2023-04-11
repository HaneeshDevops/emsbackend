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
@Table(name="events")
public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eventId;
	private String name;
	private String eventDesc;
	@OneToMany(mappedBy="event")
	public List<Booking>bookingList=new ArrayList<Booking>();
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Event(String name, String eventDesc, List<Booking> bookingList) {
		super();
		this.name = name;
		this.eventDesc = eventDesc;
		this.bookingList = bookingList;
	}



	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	
	public List<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}



	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", name=" + name + ", eventDesc=" + eventDesc + ", bookingList="
				+ bookingList + "]";
	}

	
	

}
