package com.user.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dtos.UsersDto;
import com.user.entity.Users;
import com.user.repository.UserRepository;
import com.user.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Override
	public UsersDto addNewUser(UsersDto usersDto) {
		Optional<Users> userDto = this.userRepository.findByEmail(usersDto.getEmail());
		if (!userDto.isPresent()) {
			Users users = new Users();
			users.setFirstName(usersDto.getFirstName());
			users.setLastName(usersDto.getLastName());
			users.setDob(usersDto.getDob());
			users.setCity(usersDto.getCity());
			users.setEmail(usersDto.getEmail());
			users.setPassword(usersDto.getPassword());
			users.setIsActive(true);
			this.userRepository.save(users);
			
		}
		return usersDto;
	}

}
