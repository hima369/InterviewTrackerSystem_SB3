package com.wellsfargo.sba3.its.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.sba3.its.dao.InterviewsRepository;
import com.wellsfargo.sba3.its.entity.Interviews;
import com.wellsfargo.sba3.its.exceptions.ItsException;


@Service
public class InterviewsServiceImp implements InterviewsService{
	@Autowired
	private InterviewsRepository interviewRepo;
	
	@Override
	@Transactional
	public Interviews add(Interviews interview) throws ItsException {
		if(interview!=null) {
			if(interviewRepo.existsById(interview.getInterviewId())) {
				throw new ItsException("Interview ID already used!");
			}
			
			interviewRepo.save(interview);
		}
		return interview;
	}

	@Override
	public Interviews save(Interviews interview) throws ItsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public boolean deleteInterview(int interviewId) throws ItsException {
		if(!interviewRepo.existsById(interviewId)) {
			throw new ItsException("InterviewID Not Found");
		}
	
		interviewRepo.deleteById(interviewId);
		return true;
	}


	@Override
	public List<Interviews> getAllInterviews() throws ItsException {
		return interviewRepo.findAll();
	}
	
	@Override
	public List<Interviews> getAllByInterviewName(String interviewName) throws ItsException {
		List<Interviews> name =  interviewRepo.findAllByInterviewName(interviewName);
		if(name.isEmpty()) 
			throw new ItsException("Interview Name Not Found");
		return name;
	}
	
	@Override
	public List<Interviews> getAllByInterviewerName(String interviewerName) throws ItsException {
		List<Interviews> name =  interviewRepo.findAllByInterviewerName(interviewerName);
		if(name.isEmpty()) 
			throw new ItsException("Interviewer Name Not Found");
			
		return name;
	}
	
	@Override
	public Interviews getInterviewById(int interviewId) throws ItsException {
		return interviewRepo.findById(interviewId).orElse(null);		
	}

	@Override
	public Integer getTotalCount() throws ItsException {
		return (int) interviewRepo.count();
	}
	
	@Override
	@Transactional
	public Interviews updateStatus(int interviewId, String interviewStatus) throws ItsException {
		Interviews interview = new Interviews();
		if (!interviewRepo.existsById(interviewId)) {
				throw new ItsException("Interview Not Found");
		} else {
			interviewRepo.updateStatusOfInterview(interviewId,interviewStatus);
		}
		return interviewRepo.findById(interviewId).orElse(null);
	}

}
