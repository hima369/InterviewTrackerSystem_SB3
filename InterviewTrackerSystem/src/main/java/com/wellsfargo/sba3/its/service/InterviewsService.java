package com.wellsfargo.sba3.its.service;

import java.util.List;

import com.wellsfargo.sba3.its.entity.Interviews;
import com.wellsfargo.sba3.its.entity.Users;
import com.wellsfargo.sba3.its.exceptions.ItsException;

public interface InterviewsService {


	Interviews add(Interviews interview) throws ItsException;

	Interviews save(Interviews interview) throws ItsException;
		
	boolean deleteInterview(int interviewId) throws ItsException;

	List<Interviews> getAllInterviews() throws ItsException;
	
	List<Interviews>  getAllByInterviewName(String interviewName) throws ItsException;
	
	List<Interviews> getAllByInterviewerName(String interviewerName) throws ItsException;

	Interviews getInterviewById(int interviewId) throws ItsException;
	
	Integer getTotalCount() throws ItsException;

	Interviews updateStatus(int interviewId, String interviewStatus) throws ItsException;
}
