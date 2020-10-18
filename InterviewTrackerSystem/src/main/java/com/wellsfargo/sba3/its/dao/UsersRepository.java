package com.wellsfargo.sba3.its.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wellsfargo.sba3.its.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	@Query("SELECT i FROM Users i where i.userId = :userId")
	public List<Users> findAllByUserId(@Param("userId") Integer userId);
	

	//@Query("SELECT userId FROM Users a WHERE a.userId = :userId")
	//public ArrayList findAllUsersAttendedInterview(int userId);
}
