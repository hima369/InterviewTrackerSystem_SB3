package com.wellsfargo.sba3.its.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wellsfargo.sba3.its.entity.Interviews;

@Repository
public interface InterviewsRepository extends JpaRepository<Interviews, Integer> {
	List<Interviews> findAllByInterviewerName(String interviewerName);
	List<Interviews> findAllByInterviewName(String interviewName);
	
	@Transactional
	@Modifying
	@Query("update Interviews i set i.interviewStatus = :interviewStatus where i.interviewId = :interviewId")
	public Integer updateStatusOfInterview(@Param("interviewId") Integer interviewId, @Param("interviewStatus") String interviewStatus);

	@Query("SELECT i FROM Interviews i where i.interviewId = :interviewId")
	public List<Interviews> findAllByInterviewId(@Param("interviewId") Integer interviewId);
	
}
