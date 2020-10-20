package com.wellsfargo.sba3.its.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.sba3.its.entity.Interview;
import com.wellsfargo.sba3.its.exception.UserNotFoundException;
import com.wellsfargo.sba3.its.exception.model.ExceptionResponse;
import com.wellsfargo.sba3.its.service.Impl.InterviewServiceImpl;

@RestController
@RequestMapping("/api1")
public class InterviewController {
	@Autowired
	InterviewServiceImpl interviewservice;
	
	@GetMapping("/interview")
	public ResponseEntity<List<Interview>> getAllInterviews(){
		List<Interview> interviews = this.interviewservice.getallInterview();
		ResponseEntity<List<Interview>> response = new ResponseEntity<List<Interview>>(interviews, HttpStatus.OK);
		return response;		
	}
	
	@GetMapping("/interview/{id}")
	public ResponseEntity<Interview> getInterviewById(@PathVariable("id") Long interviewid){
		Interview interview = this.interviewservice.getinterviewbyId(interviewid);
		ResponseEntity<Interview> response = new ResponseEntity<Interview>(interview, HttpStatus.OK);
		return response;
	}

	@PostMapping("/interviews")
	public ResponseEntity<Interview> addInterview(@RequestBody Interview interview ){
		Interview addinterview = this.interviewservice.addinterview(interview);
		ResponseEntity<Interview> response = new ResponseEntity<Interview>(addinterview, HttpStatus.OK);
		return response;		
	}
	
	@PutMapping("/interviews")
	public ResponseEntity<Interview> updateInterview(@RequestBody Interview interview){
		Interview updateinterview = this.interviewservice.updateinterview(interview);
		ResponseEntity<Interview> response = new ResponseEntity<Interview>(updateinterview, HttpStatus.OK);
		return response;		
	}
	
	@DeleteMapping("/interview/{id}")
	public ResponseEntity<Interview> deleteInterview(@PathVariable("id") Long interviewid){
		Interview deleteinterviewid = this.interviewservice.getinterviewbyId(interviewid);
		if(deleteinterviewid!=null) {
			this.interviewservice.deleteinterview(interviewid);
		}
		ResponseEntity<Interview> response = new ResponseEntity<Interview>(deleteinterviewid, HttpStatus.OK);
		return response;		
	}
	
	//Exception Handler
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse>handler(UserNotFoundException ex){
		
		ExceptionResponse exResponse =
				new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse> response = 
				new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.NOT_FOUND);
		
		return response;		
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handler(Exception ex) {
		ExceptionResponse exResponse =
				new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> response = 
				new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.BAD_REQUEST);
		return response;
	}
}
