package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.BookingDTO;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Booking;
import com.example.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	BookingService bookingService;
	
	@PostMapping(value="/addbooking")
	public ResponseEntity<BookingDTO> makeBooking(@RequestBody BookingDTO bookingDTO) {
		return new ResponseEntity<>(bookingService.makeBooking(bookingDTO),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/cancelbooking/{bookingId}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable(value="bookingId") int id) throws ResourceNotFoundException {
		return new ResponseEntity<>(bookingService.cancelBooking(id),HttpStatus.ACCEPTED);
	}
	@GetMapping("/viewbooking/{bookingId}")
	public ResponseEntity<Booking> viewBooking(@PathVariable(value="bookingId")int id) throws ResourceNotFoundException {
		return new ResponseEntity<>(bookingService.viewBooking(id),HttpStatus.ACCEPTED);
	}
	@GetMapping("/")
	public ResponseEntity<List<Booking>> viewAllBookings(){
		return (new ResponseEntity<>(bookingService.viewAllBookings(),HttpStatus.ACCEPTED));
	}
}
