package com.wellsfargo.sba3.its.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.sba3.its.dao.AttendeeRepository;
import com.wellsfargo.sba3.its.dao.InterviewsRepository;
import com.wellsfargo.sba3.its.dao.UsersRepository;
import com.wellsfargo.sba3.its.entity.Attendee;
import com.wellsfargo.sba3.its.entity.Interviews;
import com.wellsfargo.sba3.its.entity.Users;
import com.wellsfargo.sba3.its.exceptions.ItsException;

@Service
public class AttendeeServiceImp implements AttendeeService{

	@Autowired
	private AttendeeRepository attendeeRepo;
	
	@Autowired
	private UsersRepository userRepo;
	
	@Autowired
	private InterviewsRepository interviewRepo;
	
	@Override
	public Attendee addAttendee(int userId, int interviewId) throws ItsException {
		Attendee attendee = new Attendee();
		if (interviewRepo.existsById(interviewId)) {
			if (userRepo.existsById(userId)) {
				int count = attendeeRepo.getInterviewAttendedByUser(userId, interviewId);
				if (count>0) {
					throw new ItsException("Seems like the User has already attended the interview"); 
				} else {
					attendee.setUserId(userId);
					attendee.setInterviewId(interviewId);
					attendeeRepo.save(attendee);
				}
			} else
				throw new ItsException("User Not Found");		
		} else
			throw new ItsException("Interview Not Found");
		return attendee;
	}

	@Override
	public ArrayList getInterviewsByUserID(int userId) throws ItsException {
		List<Interviews> interviews = null;
		ArrayList al = new ArrayList();
		if (userRepo.existsById(userId)) {
			
			List<Attendee> attendee = attendeeRepo.findAllByUserId(userId);
			if (attendee.isEmpty())
				throw new ItsException("Looks like the user never attendee any interview! No interviews found");
			else {
				System.out.println("Fine till here");
				List<Integer> interviewIds = attendeeRepo.findAllInterviewsAttendedByUser(userId);				
				for (int i = 0;i<interviewIds.size();i++) {
					interviews=(interviewRepo.findAllByInterviewId(interviewIds.get(i)));
					al.add(interviews);
				}
			}
		} else {
			throw new ItsException("User Not Found");
		}
		return al;
	}

	@Override
	public ArrayList getUsersByInterviewID(int interviewId) throws ItsException {
		List<Users> users = null;
		ArrayList al = new ArrayList();
		if (interviewRepo.existsById(interviewId)) {
			
			List<Attendee> attendee = attendeeRepo.findAllByInterviewId(interviewId);
			if (attendee.isEmpty())
				throw new ItsException("Looks like the no user attended the interview! No users found");
			else {
				List<Integer> userIds = attendeeRepo.findAllUsersAttendedInterview(interviewId);				
				for (int i = 0;i<userIds.size();i++) {
					users=(userRepo.findAllByUserId(userIds.get(i)));
					al.add(users);
				}
			}
		} else {
			throw new ItsException("Interview Not Found");
		}
		return al;
	}

	


}
