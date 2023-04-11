package com.cg.ems.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.BookingDao;
import com.cg.ems.dao.EventDao;
import com.cg.ems.dao.FoodItemsDao;
import com.cg.ems.dao.UserDao;
import com.cg.ems.dao.VenueDao;
import com.cg.ems.dto.BookingDTO;
import com.cg.ems.entity.Booking;
import com.cg.ems.entity.Event;
import com.cg.ems.entity.FoodItems;
import com.cg.ems.entity.User;
import com.cg.ems.entity.Venue;
import com.cg.ems.service.BookingService;

import jakarta.transaction.Transactional;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingDao bookingDao;
	@Autowired
	private EventDao eventDao;
	@Autowired
	private VenueDao venueDao;
	@Autowired
	private FoodItemsDao foodItemsDao;
//	@Autowired
//	private UserDao userDao;

	
	
	@Override
	public BookingDTO saveBooking(BookingDTO bookingDTO) {
	    int eventId = bookingDTO.getEventId();
	    int venueId = bookingDTO.getVenueId();
	    int foodId = bookingDTO.getFoodId();
	    Event event = eventDao.findById(eventId).orElse(null);
	    Venue venue = venueDao.findById(venueId).orElse(null);
	    FoodItems foodItems = foodItemsDao.findById(foodId).orElse(null);
	    if (event != null||venue != null  ||foodItems != null) {
	        Booking booking = new Booking();
	        BeanUtils.copyProperties(bookingDTO, booking);
	        booking.setEvent(event);
	        booking.setVenue(venue);
	        booking.setFoodItems(foodItems);
	        // Set the date to the current date if it's null in the BookingDTO object
	        if (bookingDTO.getDate() == null) {
	            booking.setDate(new Date());
	        }
	        
	        bookingDao.save(booking);
	        BeanUtils.copyProperties(booking, bookingDTO);
	    }
	    return bookingDTO;
	}
//	@Transactional
//	@Override
//	public BookingDTO saveBooking(BookingDTO bookingDTO) {
//	    int eventId = bookingDTO.getEventId();
//	    int venueId = bookingDTO.getVenueId();
//	    int foodId = bookingDTO.getFoodId();
//	    Event event = eventDao.findById(eventId).orElse(null);
//	    Venue venue = venueDao.findById(venueId).orElse(null);
//	    FoodItems foodItems = foodItemsDao.findById(foodId).orElse(null);
//	    if (event != null && venue != null && foodItems != null) {
//	        Booking booking = new Booking();
//	        BeanUtils.copyProperties(bookingDTO, booking);
//	        booking.setEvent(event);
//	        booking.setVenue(venue);
//	        booking.setFoodItems(foodItems);
//	        bookingDao.save(booking);
//	        //bookingDao.flush(); // add this line to save the changes to the database
//	        BeanUtils.copyProperties(booking, bookingDTO);
//	    }

//
//	@Override
//	public BookingDTO updateBooking(BookingDTO bookingDTO) {
//		// TODO Auto-generated method stub
//		Booking booking = new Booking();
//		
//		BeanUtils.copyProperties(bookingDTO, booking);
//		  if (booking.getDate() == null) {
//		        booking.setDate(new Date());
//		        bookingDTO.setDate(booking.getDate()); 
//		    }
//		bookingDao.save(booking);
//		return bookingDTO;
//	}
	@Override
	public BookingDTO updateBooking(BookingDTO bookingDTO) {
	    Booking booking = new Booking();
	    BeanUtils.copyProperties(bookingDTO, booking);
	    
	    // Set the venue, event, and food objects based on their IDs
	    Venue venue = venueDao.findById(bookingDTO.getVenueId()).orElse(null);
	    Event event = eventDao.findById(bookingDTO.getEventId()).orElse(null);
	    FoodItems food = foodItemsDao.findById(bookingDTO.getFoodId()).orElse(null);
	    
	    booking.setVenue(venue);
	    booking.setEvent(event);
	    booking.setFoodItems(food);
	    // If the date field is null, set it to the current date
	    if (booking.getDate() == null) {
	        booking.setDate(new Date());
	    }
	    
	    // Save the booking object to the database
	    bookingDao.save(booking);
	    
	    // Update the BookingDTO object with the new values
	    BookingDTO updatedBookingDTO = new BookingDTO();
	    BeanUtils.copyProperties(booking, updatedBookingDTO);
	    updatedBookingDTO.setVenueId(venue.getVenueId());
	    updatedBookingDTO.setEventId(event.getEventId());
	    updatedBookingDTO.setFoodId(food.getFoodId());
//	    if (booking.getDate() == null) {
//       booking.setDate(new Date());
//	        bookingDTO.setDate(booking.getDate()); 
//    }
	    
	    return updatedBookingDTO;
	}


	@Override
	public BookingDTO deleteBooking(BookingDTO bookingDTO) {
		// TODO Auto-generated method stub
		Booking booking = new Booking();
		BeanUtils.copyProperties(bookingDTO, booking);
		bookingDao.delete(booking);
		return bookingDTO;
	}

	@Override
	public BookingDTO getByBookingId(int bookingId) {
		// TODO Auto-generated method stub
//		Optional<Booking> booking = bookingDao.findById(bookingId);
//		if (booking.isPresent()) {
//			// convert the entity to DTO
//			BookingDTO dto = new BookingDTO();
//			BeanUtils.copyProperties(booking.get(), dto);
//			return dto;
//		}
//		return null;
//	}
		Optional<Booking> booking = bookingDao.findById(bookingId);
	    if (booking.isPresent()) {
	        BookingDTO dto = new BookingDTO();
	        BeanUtils.copyProperties(booking.get(), dto);
	        dto.setEventId(booking.get().getEvent().getEventId());
	        dto.setVenueId(booking.get().getVenue().getVenueId());
	        dto.setFoodId(booking.get().getFoodItems().getFoodId());
	        dto.setBookingId(booking.get().getBookingId());
	        return dto;
	    }
	    return null;
	}

	@Override
	public List<BookingDTO> findAll() {
		// TODO Auto-generated method stub
//		Iterable<Booking> list = bookingDao.findAll();
//		List<BookingDTO> dtos = new ArrayList<>();
//		for (Booking b : list) {
//			BookingDTO dto = new BookingDTO();
//			BeanUtils.copyProperties(b, dto);
//			dtos.add(dto);
//		}
//		return dtos;
	//}
		 Iterable<Booking> list = bookingDao.findAll();
		    List<BookingDTO> dtos = new ArrayList<>();
		    for (Booking b : list) {
		        BookingDTO dto = new BookingDTO();
		        BeanUtils.copyProperties(b, dto);
		        dto.setEventId(b.getEvent().getEventId());
		        dto.setVenueId(b.getVenue().getVenueId());
		        dto.setFoodId(b.getFoodItems().getFoodId());
		        dtos.add(dto);
		    }
		    return dtos;

}
}
