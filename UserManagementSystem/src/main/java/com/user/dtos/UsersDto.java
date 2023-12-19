package com.user.dtos;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UsersDto {
	//private Integer userId;
	private String firstName;
	private String lastName;
	private Date dob;
	private String city;
	private String email;
	private String password;
	private Boolean isActive;
	private String status;
}
