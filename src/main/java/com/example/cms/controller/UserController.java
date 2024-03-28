package com.example.cms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cms.model.User;
import com.example.cms.responseDTO.UserResponse;
import com.example.cms.service.UserService;
import com.example.cms.userDTO.UserRequestDTO;
import com.example.cms.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping(value= "/users/register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody @Valid UserRequestDTO user){
		return userService.registerUser(user);
	}
	
	@DeleteMapping("users/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>> deleteUser(@PathVariable  int userId){
		return userService.deleteUser(userId);
	}
	
	@GetMapping("/test")
	public String test() {
		return "hello from cms";
	}
	
	@GetMapping("users/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>>  findByUserId(@PathVariable  int userId){
		return userService.findByUserId(userId);
	}
}
          