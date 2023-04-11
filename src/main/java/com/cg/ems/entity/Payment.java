package com.cg.ems.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="payments")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long paymentId;
	public double amount;
	public String status;
	public Date date;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="booking_id")
	private Booking booking;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}



	



	public Payment(long paymentId, double amount, String status, Date date, Booking booking) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.status = status;
		this.date = date;
		this.booking = booking;
	}







	public long getPaymentId() {
		return paymentId;
	}



	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Booking getBooking() {
		return booking;
	}



	public void setBooking(Booking booking) {
		this.booking = booking;
	}



	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", amount=" + amount + ", status=" + status + ", date=" + date
				+ ", booking=" + booking + "]";
	}


	
}
