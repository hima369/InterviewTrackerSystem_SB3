package com.wellsfargo.sba3.its.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.sba3.its.entity.Interviews;
import com.wellsfargo.sba3.its.exceptions.ItsException;
import com.wellsfargo.sba3.its.service.InterviewsService;

@RestController
@RequestMapping("/interviews")

public class InterviewsRestController {
	
	 @Autowired private InterviewsService interviewsService;
		
		@GetMapping
		public ResponseEntity<List<Interviews>> getAllInterviews() throws ItsException{
			return new ResponseEntity<List<Interviews>>(interviewsService.getAllInterviews(), HttpStatus.OK);
		}
		
		@GetMapping("/{interviewId}")
		public ResponseEntity<Interviews> getInterviewById(@PathVariable("interviewId") int interviewId) throws ItsException{
			ResponseEntity<Interviews> response=null;
			
			Interviews interview = interviewsService.getInterviewById(interviewId); 
			
			if(interview!=null) {
				response =new ResponseEntity<Interviews>(interview, HttpStatus.OK); 
			}else {
				response =new ResponseEntity<Interviews>(HttpStatus.NOT_FOUND);
			}
			
			return response;
		}
		
		@DeleteMapping("/{interviewId}")
		public ResponseEntity<Void> deleteInterviewById(@PathVariable("interviewId") int interviewId) throws ItsException{
			ResponseEntity<Void> response=null;
			
			boolean isDeleted = interviewsService.deleteInterview(interviewId);
			
			if(isDeleted) {		
				response =new ResponseEntity<>(HttpStatus.OK); 
			}else {
				response =new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return response;
		}
		
		@PostMapping
		public ResponseEntity<Interviews> addInterview(@RequestBody Interviews interview) throws ItsException{
			return new ResponseEntity<Interviews>(interviewsService.add(interview),HttpStatus.OK);
		}
		
		@GetMapping("interviewName/{interviewName}")
		public ResponseEntity<List<Interviews>> getInterviewByInterviewName(@PathVariable("interviewName") String interviewName) throws ItsException{
			ResponseEntity<List<Interviews>> response=null;
			List<Interviews> name = interviewsService.getAllByInterviewName(interviewName); 
			
			if(name.isEmpty()) {
				response =new ResponseEntity<List<Interviews>>(HttpStatus.NOT_FOUND);
			}else {
				response =new ResponseEntity<List<Interviews>>(name, HttpStatus.OK);
				}
			
			return response;
		}
		
		@GetMapping("interviewerName/{interviewerName}")
		public ResponseEntity<List<Interviews>> getInterviewByInterviewerName(@PathVariable("interviewerName") String interviewerName) throws ItsException{
			ResponseEntity<List<Interviews>> response=null;
			List<Interviews> name = interviewsService.getAllByInterviewerName(interviewerName); 
			
			if(name.isEmpty()) {
				response =new ResponseEntity<List<Interviews>>(HttpStatus.NOT_FOUND);
			}else {
				response =new ResponseEntity<List<Interviews>>(name, HttpStatus.OK);
				}
			
			return response;
		}
		 
		@GetMapping("count")
		public ResponseEntity<String> getCountOfInterviews() throws ItsException{
			ResponseEntity<String> response=null;
			int total = interviewsService.getTotalCount(); 
			
			response =new ResponseEntity<String>("Total Count of records = " + total,HttpStatus.NOT_FOUND);
			return response;
		}
		
		@PutMapping("update/{interviewId}/{interviewStatus}")
		public ResponseEntity<Interviews> updateStatus(@PathVariable("interviewId") int interviewId,@PathVariable("interviewStatus") String interviewStatus) throws ItsException{
			ResponseEntity<Interviews> response=null;
			Interviews interview = interviewsService.updateStatus(interviewId, interviewStatus);
			if(interview==null) {
				response =new ResponseEntity<Interviews>(HttpStatus.NOT_FOUND);
			}else {
				response =new ResponseEntity<Interviews>(interview, HttpStatus.OK);
			}
			
			return response;
		}
			
		
}
