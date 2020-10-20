package com.wellsfargo.sba3.its.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wellsfargo.sba3.its.entity.User;


public interface UserService {	
	public List<User> getAll();
	public User getById(Long id);
	public User add(User user);
	public User update(User user);
	public User delete(Long id);

}
