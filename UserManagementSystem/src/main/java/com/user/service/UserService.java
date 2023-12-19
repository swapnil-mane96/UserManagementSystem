package com.user.service;

import java.util.List;

import com.user.dtos.UsersDto;
import com.user.entity.Users;

public interface UserService {
	// used to add new user
	UsersDto addNewUser(UsersDto usersDto);
	
	//used to get all users list
	List<Users> getAllUsers();
	
	// get single user
	UsersDto getOneUser(Integer id);
	
	// update user data
	UsersDto updateUserData(Integer userId, UsersDto usersDto);
	
	// delete user
	Boolean deleteUser(Integer userId);
}
