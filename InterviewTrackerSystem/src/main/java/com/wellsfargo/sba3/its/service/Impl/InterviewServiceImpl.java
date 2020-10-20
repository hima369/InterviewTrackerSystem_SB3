package com.wellsfargo.sba3.its.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.sba3.its.entity.Interview;
import com.wellsfargo.sba3.its.repository.InterviewRepository;
import com.wellsfargo.sba3.its.service.InterviewService;

@Service
public class InterviewServiceImpl implements InterviewService{

	@Autowired
	InterviewRepository interviewrepo;
	
	@Override
	public List<Interview> getallInterview() {
		// TODO Auto-generated method stub
		return this.interviewrepo.findAll();
	}

	@Override
	public Interview getinterviewbyId(Long interviewid) {
		// TODO Auto-generated method stub
		return this.interviewrepo.findById(interviewid).orElse(null);
	}

	@Override
	public Interview addinterview(Interview interview) {
		// TODO Auto-generated method stub
		return this.interviewrepo.save(interview);
	}

	@Override
	public Interview updateinterview(Interview interview) {
		// TODO Auto-generated method stub
		return this.interviewrepo.save(interview);
	}

	@Override
	public Interview deleteinterview(Long interviewid) {
		// TODO Auto-generated method stub
		Interview interview = this.getinterviewbyId(interviewid);
		if(interview!=null) {
			this.interviewrepo.deleteById(interviewid);
		}
		return interview;
	}

}
