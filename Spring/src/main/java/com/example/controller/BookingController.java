package com.example.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Booking;
import com.example.repository.IBookingRepository;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	IBookingRepository repo;
	@PostMapping(value="/addbooking")
	public boolean makeBooking(@RequestBody Booking b) {
		b.setBookingDate(LocalDate.now());
		repo.save(b);
		return true;
	}
	@DeleteMapping("/cancelbooking/{bookingId}")
	public Booking cancelBooking(@PathVariable(value="bookingId") int id) {
		Booking b = repo.findById(id).orElseThrow();
		repo.delete(b);
		return b;
	}
	@GetMapping("/viewbooking/{bookingId}")
	public Booking viewBooking(@PathVariable(value="bookingId")int id) {
		return repo.findById(id).orElseThrow();
	}
	@GetMapping("/")
	public List<Booking> viewAllBookings(){
		return repo.findAll();
	}
}
