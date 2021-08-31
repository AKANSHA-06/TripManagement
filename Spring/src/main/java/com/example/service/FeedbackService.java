package com.example.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Customer;
import com.example.model.Feedback;
import com.example.repository.ICustomerRepository;
import com.example.repository.IFeedbackRepository;

@Service
public class FeedbackService {
	@Autowired
	IFeedbackRepository feedbackRepo;
	@Autowired
	ICustomerRepository customerRepo;
	
	public Feedback addfeedback(int customerId,Feedback feedback) throws ResourceNotFoundException{
		feedback.setSubmitDate(LocalDate.now());
		Customer c = customerRepo.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer ID: "+customerId+" not found!!"));
		feedback.setCustomer(c);
		return feedbackRepo.save(feedback);
	}
	
	
	public Feedback findByfeedbackId(String id) throws ResourceNotFoundException {
		return feedbackRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Feedback ID: "+id+"not found!!"));
	}
		
	
	public List<Feedback> findByCustomerId(int id) throws ResourceNotFoundException{
		if(!customerRepo.existsById(id))
			throw new ResourceNotFoundException("Customer ID: "+id+" not found!!");
		return feedbackRepo.findByCustomerId(id);
	}
	
	public List<Feedback> viewAllFeedbacks(){
		return feedbackRepo.findAll();
	}
	

}
