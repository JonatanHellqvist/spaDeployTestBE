package com.kattspa.kattspa.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.kattspa.kattspa.models.Bookings;
import com.kattspa.kattspa.services.BookingService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
// @CrossOrigin(origins = "http://localhost:5173")
public class BookingsController {

	private BookingService bookingService;

	public BookingsController(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	
	@GetMapping
	public String getRoot() {
		return "{'Hello': 'World'}";
	}

	@PostMapping("/booking")
	public Bookings addBooking(@RequestBody Bookings booking) {
		return bookingService.addBooking(booking);
	}

	@GetMapping("/bookings") 
	public List<Bookings> getBookings() {
		return bookingService.getBookings();
	}

	@GetMapping("/booking/{id}")
	public Bookings getSpaceship(@PathVariable String id) {
		return bookingService.getBooking(id);
	} 
	
	@PatchMapping("/booking/{id}")
	public Bookings editBooking(@PathVariable String id, @RequestBody Bookings booking) {
		return bookingService.editBooking(id,booking);
	}

	@DeleteMapping("booking/{id}")
	public String deleteBooking(@PathVariable String id) {

		bookingService.deleteBooking(id);
		return "{'message': 'Booking with id " + id + " has been deleted'}";
	}

	
	
}
