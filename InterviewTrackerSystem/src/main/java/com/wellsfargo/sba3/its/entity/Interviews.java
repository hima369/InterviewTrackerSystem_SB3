package com.wellsfargo.sba3.its.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="interviews")
public class Interviews implements Serializable{

	@Id
	@Column(name="interviewId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int interviewId;
	
	@Column(name="interviewerName")
	@NotBlank(message="Interviewer Name cannot be blank")
	@NotNull(message="Interviewer Name cannot be null")
	@Size(min=5, max =30, message="Interviewer Name should be characters of length between 5 and 30")
	private String interviewerName ;
	
	@Column(name="interviewName")
	@NotBlank(message="Interview Name cannot be blank")
	@NotNull(message="Interview Name cannot be null")
	@Size(min=3, max=30,message="Interview Name should be characters of length between 3 and 30")
	private String interviewName ;
	
	@Column(name="usersSkill")
	@NotBlank(message="User Skill cannot be blank")
	@NotNull(message="User Skill cannot be null")
	@Size(min=5, max=30,message="User Skill should be characters of length between 5 and 30")
	private String usersSkill;
	
	@Column(name="interviewStatus")
	@NotBlank(message="Interview Status cannot be blank")
	@NotNull(message="Interview Status cannot be null")
	@Size(min=5,max=100,message="Interview Status should be of length between 5 and 100")
	private String interviewStatus ;
	
	@Column(name="remarks")
	@NotBlank(message="Remarks cannot be blank")
	@NotNull(message="Remarks cannot be null")
	@Size(min=5, max=100,message="Remarks should be characters of length between 5 and 100")
	private String remarks ;
	
	@Column(name="date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate date;
	
	@Column(name="time")
	@DateTimeFormat(iso = ISO.TIME)
	private LocalDate time;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}

	public int getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}

	public String getInterviewerName() {
		return interviewerName;
	}

	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}

	public String getInterviewName() {
		return interviewName;
	}

	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}

	public String getUsersSkill() {
		return usersSkill;
	}

	public void setUsersSkill(String usersSkill) {
		this.usersSkill = usersSkill;
	}

	public String getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Interviews() {
		super();
	}

	public Interviews(int interviewId,String interviewerName, String interviewName, String usersSkill, String interviewStatus, String remarks) {
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.usersSkill = usersSkill;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
	}
	
}
