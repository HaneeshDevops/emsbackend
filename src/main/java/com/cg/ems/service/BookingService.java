package com.cg.ems.service;

import java.util.List;

import com.cg.ems.dto.BookingDTO;

public interface BookingService {
	public BookingDTO saveBooking(BookingDTO bookingDTO);
	public BookingDTO updateBooking(BookingDTO bookingDTO);
	public BookingDTO deleteBooking(BookingDTO bookingDTO);

	public BookingDTO getByBookingId(int bookingId);

	public List<BookingDTO> findAll();
}
