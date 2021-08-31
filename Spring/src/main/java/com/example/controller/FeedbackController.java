package com.example.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Feedback;
import com.example.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;
	
	@PostMapping(value="/addfeedback/{customerId}")
	public ResponseEntity<Feedback> addfeedback(@PathVariable(value="customerId")int customerId,@RequestBody Feedback feedback) throws ResourceNotFoundException {
		return new ResponseEntity<>(feedbackService.addfeedback(customerId, feedback),HttpStatus.CREATED);
	}
	
	@GetMapping("/viewfeedback/{feedbackId}")
	public ResponseEntity<Feedback> findByfeedbackId(@PathVariable(value="feedbackId")String id) throws ResourceNotFoundException{
		return new ResponseEntity<>(feedbackService.findByfeedbackId(id),HttpStatus.OK);
	}
	
	@GetMapping("/viewfeedbacks/{customerId}")
	public ResponseEntity<List<Feedback>> findByCustomerId(@PathVariable(value="customerId")int id) throws ResourceNotFoundException{
		return new ResponseEntity<>(feedbackService.findByCustomerId(id),HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<Feedback>> viewAllFeedbacks(){
		return new ResponseEntity<>(feedbackService.viewAllFeedbacks(),HttpStatus.OK);
	}

}
