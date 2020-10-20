package com.wellsfargo.sba3.its.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.sba3.its.entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long>{

}
