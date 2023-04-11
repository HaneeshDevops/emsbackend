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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.dto.BookingDTO;
import com.cg.ems.exception.BookingNotFoundException;
import com.cg.ems.service.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	// http://localhost:8081/api/booking/addBooking
	@PostMapping("/addBooking")
	public ResponseEntity<BookingDTO> addBooking(@RequestBody BookingDTO bookingDTO) {
		BookingDTO booking = bookingService.saveBooking(bookingDTO);
		return ResponseEntity.ok(booking);
	}

	@GetMapping("/getBookingByBookingId/{bookingId}")
	public ResponseEntity<BookingDTO> getByBookingId(@PathVariable int bookingId) {
		BookingDTO bookingDTO = bookingService.getByBookingId(bookingId);
		if (bookingDTO != null) {
			return new ResponseEntity<BookingDTO>(bookingDTO, HttpStatus.FOUND);
		}
		throw new BookingNotFoundException("Booking with id" + bookingId + "doesn't exist");
	}

	@PutMapping("/updateBooking/{bookingId}")
	public ResponseEntity<BookingDTO> updateBooking(@RequestBody BookingDTO bookingDTO) {
		BookingDTO booking = bookingService.updateBooking(bookingDTO);
		return new ResponseEntity<BookingDTO>(booking, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/deleteBookingByBookingId/{bookingId}")
	public ResponseEntity<Boolean> deleteByBookingId(@PathVariable Integer bookingId) {
		BookingDTO bookingDTO = bookingService.getByBookingId(bookingId);
		if (bookingDTO != null) {
			bookingService.deleteBooking(bookingDTO);
			return new ResponseEntity<Boolean>(HttpStatus.ACCEPTED);
		}
		throw new BookingNotFoundException("Booking with id" + bookingId + "doesn't exist");

	}

	@GetMapping("/getAllBookings")
	public ResponseEntity<List<BookingDTO>> getAllBookings() {
		List<BookingDTO> list = bookingService.findAll();
		return ResponseEntity.ok(list);
	}
}
