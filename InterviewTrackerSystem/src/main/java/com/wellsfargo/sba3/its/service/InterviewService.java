package com.wellsfargo.sba3.its.service;

import java.util.List;

import com.wellsfargo.sba3.its.entity.Interview;

public interface InterviewService {
	public List<Interview> getallInterview();
	public Interview getinterviewbyId(Long interviewid);
	public Interview addinterview(Interview interview);
	public Interview updateinterview(Interview interview);
	public Interview deleteinterview(Long interviewid);
	

}
