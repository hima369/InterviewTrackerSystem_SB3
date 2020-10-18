package com.wellsfargo.sba3.its.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.sba3.its.entity.Attendee;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Integer> {
	
	@Query("SELECT count(*) FROM Attendee i WHERE i.userId = :userId and i.interviewId = :interviewId")
	public Integer getInterviewAttendedByUser(int userId,int interviewId);
	
	@Query("SELECT interviewId FROM Attendee a WHERE a.userId = :userId")
	public ArrayList findAllInterviewsAttendedByUser(int userId);
	
	@Query("SELECT userId FROM Attendee a WHERE a.interviewId = :interviewId")
	public ArrayList findAllUsersAttendedInterview(int interviewId);

	List<Attendee> findAllByUserId(int userId);
	
	List<Attendee> findAllByInterviewId(int interviewId);
	
	List<Integer> findInterviewIdByUserId(int userId);
	
}
