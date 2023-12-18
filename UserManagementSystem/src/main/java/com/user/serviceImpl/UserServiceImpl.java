package com.user.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dtos.UsersDto;
import com.user.entity.Users;
import com.user.repository.UserRepository;
import com.user.service.UserService;

import jakarta.transaction.Transactional;

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

	@Override
	public List<Users> getAllUsers() {
		List<Users> allUsers = this.userRepository.findAll();
		return allUsers;
	}

	@Override
	public UsersDto getOneUser(Integer id) {
		UsersDto usersDto = new UsersDto();
		Users users = this.userRepository.findByUserId(id);
		usersDto.setFirstName(users.getFirstName());
		usersDto.setLastName(users.getLastName());
		usersDto.setCity(users.getCity());
		usersDto.setDob(users.getDob());
		usersDto.setEmail(users.getEmail());
		usersDto.setPassword(users.getPassword());
		return usersDto;
	}

	@Override
	@Transactional
	public UsersDto updateUserData(Integer userId, UsersDto usersDto) {
		Users user = this.userRepository.findByUserId(userId);
		if (user != null) {
			if (usersDto.getFirstName() != null) {
				user.setFirstName(usersDto.getFirstName());
			}
			if (usersDto.getLastName() != null) {
				user.setLastName(usersDto.getLastName());
			}
			if (usersDto.getEmail() != null) {
				user.setEmail(usersDto.getEmail());
			}
			if (usersDto.getPassword() != null) {
				user.setPassword(usersDto.getPassword());
			}
			if (usersDto.getCity() != null) {
				user.setCity(usersDto.getCity());
			}
			if (usersDto.getDob() != null) {
				user.setDob(usersDto.getDob());
			}
			this.userRepository.save(user);
		}
		return usersDto;
	}

}
