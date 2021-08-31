package com.example.service;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.BookingDTO;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Booking;
import com.example.repository.IBookingRepository;

@Service
public class BookingService {
	@Autowired
	IBookingRepository bookingRepo;
	private ModelMapper modelMapper = new ModelMapper();
	public BookingDTO makeBooking(BookingDTO bookingDTO) {
		bookingDTO.setBookingDate(LocalDate.now());
		Booking booking  = mapToEntity(bookingDTO);
		bookingRepo.save(booking);
		return mapToDTO(booking);
	
	}
	public Booking cancelBooking(int id) throws ResourceNotFoundException{
		Booking b = null;
		b = bookingRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Booking Id : "+id+" not found!!"));
		bookingRepo.delete(b);
		return b;
	}
	
	public Booking viewBooking(int id) throws ResourceNotFoundException {
		return bookingRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Booking Id : "+id+" not found!!"));
		
	}
	
	public List<Booking> viewAllBookings(){
		return bookingRepo.findAll();
	}
	
	private BookingDTO mapToDTO(Booking booking) {
		return modelMapper.map(booking, BookingDTO.class);
	}
	
	private Booking mapToEntity(BookingDTO bookingDTO) {
		return modelMapper.map(bookingDTO, Booking.class);
	}
	
}
