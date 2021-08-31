package com.example.dto;

import java.time.LocalDate;

public class BookingDTO {
	private String bookingType;
	private String description;
	private String bookingTitle;
	private LocalDate bookingDate;
	
	public BookingDTO() {}
	
	public BookingDTO(String bookingType, String description, String bookingTitle, LocalDate bookingDate) {
		this.bookingType = bookingType;
		this.description = description;
		this.bookingTitle = bookingTitle;
		this.bookingDate = bookingDate;
	}
	
	public String getBookingType() {
		return bookingType;
	}
	
	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getBookingTitle() {
		return bookingTitle;
	}
	
	public void setBookingTitle(String bookingTitle) {
		this.bookingTitle = bookingTitle;
	}
	
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	
}
