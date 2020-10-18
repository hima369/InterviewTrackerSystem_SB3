package com.wellsfargo.sba3.its.service;

import java.util.ArrayList;

import com.wellsfargo.sba3.its.entity.Attendee;
import com.wellsfargo.sba3.its.exceptions.ItsException;

public interface AttendeeService {
	
	Attendee addAttendee(int userId, int interviewID) throws ItsException;
	
	ArrayList getUsersByInterviewID(int interviewId) throws ItsException;
	
	ArrayList getInterviewsByUserID(int userId) throws ItsException;

}
