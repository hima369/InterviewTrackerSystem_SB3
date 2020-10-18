package com.wellsfargo.sba3.its.service;

import java.util.List;
import com.wellsfargo.sba3.its.entity.Users;
import com.wellsfargo.sba3.its.exceptions.ItsException;

public interface UsersService {

	Users add(Users user) throws ItsException;


	boolean deleteUser(int userId) throws ItsException;

	Users getUserById(int userId) throws ItsException;

	List<Users> getAllUsers() throws ItsException;
}
