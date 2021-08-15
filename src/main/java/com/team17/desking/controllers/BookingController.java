package com.team17.desking.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.team17.desking.entity.Booking;
import com.team17.desking.repository.BookingRepository;

@RestController
public class BookingController {

	@Autowired
	private BookingRepository bookrepo;
	@CrossOrigin()
	@GetMapping("/desking/booking/{userId}")	
	public List<Object> getUserBookings(@PathVariable Long userId){
		return bookrepo.getUserBookingsAndSeatInfo(userId);	
	}
	@CrossOrigin()
	@PostMapping("/desking/booking/create")
	public Long add(@RequestBody Booking booking) {
	    Booking newBooking = bookrepo.save(booking);
	    return newBooking.getBookingId();
	}
	@CrossOrigin()
	@DeleteMapping("/desking/booking/{bookingId}")
	public void delete(@PathVariable Long bookingId) {
	    bookrepo.deleteById(bookingId);
	}
	
	

}
