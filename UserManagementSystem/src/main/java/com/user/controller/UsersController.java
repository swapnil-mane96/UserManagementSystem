package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.dtos.UsersDto;
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

}
