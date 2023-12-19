package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.dtos.UsersDto;
import com.user.entity.Users;
import com.user.model.ReturnData;
import com.user.service.UserService;

@RestController
@RequestMapping("users")
public class UsersController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addnewuser")
	public ResponseEntity<?> addNewUser (@RequestBody UsersDto usersDto){
		ReturnData returnData = new ReturnData();
		UsersDto addNewUser = this.userService.addNewUser(usersDto);
		returnData.setData(addNewUser);
		returnData.setMessage("User added successfully...");
		returnData.setStatusCode("200");
		return new ResponseEntity<ReturnData>(returnData, HttpStatus.OK);
	}
	
	@GetMapping("/getallusers")
	public ResponseEntity<?> getAllUsers(){
		ReturnData returnData = new ReturnData();
		List<Users> allUsers = this.userService.getAllUsers();
		returnData.setData(allUsers);
		return new ResponseEntity<ReturnData>(returnData, HttpStatus.OK);
	}
	
	@GetMapping("/getoneuser/{userid}")
	public ResponseEntity<?> getOneUser(@PathVariable Integer userid){
		UsersDto oneUser = this.userService.getOneUser(userid);
		return new ResponseEntity<UsersDto>(oneUser, HttpStatus.OK);
	}
	
	@PutMapping("/updateuser/{userId}")
	public ResponseEntity<?> updateUserData(@PathVariable Integer userId, @RequestBody UsersDto usersDto){
		ReturnData returnData = new ReturnData();
		UsersDto updateUserData = this.userService.updateUserData(userId, usersDto);
		returnData.setData(updateUserData);
		returnData.setMessage("User details are updated successfully");
		returnData.setStatusCode("200");
		return new ResponseEntity<ReturnData>(returnData, HttpStatus.OK);
	}

	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
		ReturnData returnData = new ReturnData();
		Boolean deleteUser = this.userService.deleteUser(userId);
		returnData.setData(deleteUser);
		returnData.setMessage("User deleted successfully");
		returnData.setStatusCode("200");
		return new ResponseEntity<ReturnData>(returnData, HttpStatus.OK);
	}
}
