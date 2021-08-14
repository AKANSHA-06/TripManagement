package com.example.model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="feedback")
public class Feedback {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column
	private String feedbackId;
	
	@Column
	private String feedbackStatement;
	@Column
	private int rating;
	@Column
	private LocalDate submitDate;
	
	@ManyToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name="customerId")
	private Customer customer;

	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackStatement() {
		return feedbackStatement;
	}

	public void setFeedbackStatement(String feedbackStatement) {
		this.feedbackStatement = feedbackStatement;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDate getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDate submitDate) {
		this.submitDate = submitDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Feedback(String feedbackId, String feedbackStatement, int rating, LocalDate submitDate, Customer customer) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackStatement = feedbackStatement;
		this.rating = rating;
		this.submitDate = submitDate;
		this.customer = customer;
	}

	public Feedback() {
		super();
	}
	
	
	
	
	
	
}
