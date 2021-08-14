package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.model.Feedback;
@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, String>{
	
	@Query("From Feedback where customer.customerId = :customerId")
	public List<Feedback> findByCustomerId(@Param("customerId") int custId);
}
