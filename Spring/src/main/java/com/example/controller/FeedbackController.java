package com.example.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Feedback;
import com.example.repository.ICustomerRepository;
import com.example.repository.IFeedbackRepository;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	IFeedbackRepository feedbackRepo;
	@Autowired
	ICustomerRepository customerRepo;
	
	@PostMapping(value="/addfeedback/{customerId}")
	public Feedback addfeedback(@PathVariable(value="customerId")int customerId,@Validated @RequestBody Feedback feedback) {
		feedback.setSubmitDate(LocalDate.now());
		return customerRepo.findById(customerId).map(customer ->{
			feedback.setCustomer(customer);
			return feedbackRepo.save(feedback);
		}).orElse(null);
		
	}
	
	@GetMapping("/viewfeedback/{feedbackId}")
	public Feedback findByfeedbackId(@PathVariable(value="feedbackId")String id) {
		return feedbackRepo.findById(id).orElseThrow();
	}
	
	@GetMapping("/viewfeedbacks/{customerId}")
	public List<Feedback> findByCustomerId(@PathVariable(value="customerId")int id) {
		return feedbackRepo.findByCustomerId(id);
	}
	@GetMapping("/")
	public List<Feedback> viewAllFeedbacks(){
		return feedbackRepo.findAll();
	}

}
