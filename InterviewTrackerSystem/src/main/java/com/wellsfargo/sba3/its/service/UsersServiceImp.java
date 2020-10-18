package com.wellsfargo.sba3.its.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.sba3.its.dao.UsersRepository;
import com.wellsfargo.sba3.its.entity.Users;
import com.wellsfargo.sba3.its.exceptions.ItsException;
@Service
public class UsersServiceImp implements UsersService{
	
	@Autowired
	private UsersRepository userRepo;
	
	@Override
	@Transactional
	public Users add(Users user) throws ItsException {
		if(user!=null) {
			if(userRepo.existsById(user.getUserId())) {
				throw new ItsException("Interview ID already used!");
			}
			
			userRepo.save(user);
		}
		return user;
	}

	@Override
	public boolean deleteUser(int userId) throws ItsException {
		if(!userRepo.existsById(userId)) {
			throw new ItsException("User Not Found");
		}
	
		userRepo.deleteById(userId);
		return true;
	}

	

	@Override
	public List<Users> getAllUsers() throws ItsException {
		return userRepo.findAll();
	}

	@Override
	public Users getUserById(int userId) throws ItsException {
		return userRepo.findById(userId).orElse(null);	
	}

}
