package com.wellsfargo.sba3.its.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.sba3.its.entity.User;
import com.wellsfargo.sba3.its.repository.UserRepository;
import com.wellsfargo.sba3.its.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userrepo;
	
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return this.userrepo.findAll();
	}

	@Override
	public User getById(Long id) {
		// TODO Auto-generated method stub
		return this.userrepo.findById(id).orElse(null);
	}

	@Override
	public User add(User user) {
		// TODO Auto-generated method stub
		
		return this.userrepo.save(user);
		
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return this.userrepo.save(user);
	}

	@Override
	public User delete(Long id) {
		// TODO Auto-generated method stub
		User user = this.getById(id);
		if(user!=null) {
			this.userrepo.deleteById(id);;
		}
		return user;
	}

}
