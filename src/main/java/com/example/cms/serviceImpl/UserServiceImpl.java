package com.example.cms.serviceImpl;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cms.exception.UserAlreadyExistByEmailException;
import com.example.cms.model.User;
import com.example.cms.repository.UserRepository;
import com.example.cms.responseDTO.UserResponse;
import com.example.cms.service.UserService;
import com.example.cms.userDTO.UserRequestDTO;
import com.example.cms.utility.ResponseStructure;

@Service

public class UserServiceImpl implements UserService{

	private UserRepository userRepo;
	private ResponseStructure<UserResponse> structure;
	private PasswordEncoder pass;

	public UserServiceImpl(UserRepository userRepo, ResponseStructure<UserResponse> structure,PasswordEncoder pass) {
		this.userRepo = userRepo;
		this.structure = structure;
		this.pass=pass;
	}


	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> registerUser(UserRequestDTO userRequest) {
	if(userRepo.existsByEmail(userRequest.getEmail()))	
		throw new UserAlreadyExistByEmailException("Failed to register user");
		
		User user = userRepo.save(MapToUserEntity(userRequest, new User()));
		
		return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
				.setMessage("User registered successfully")
				.setBody(mapToUserResponse(user)));
		}


	private UserResponse mapToUserResponse(User user) {
		UserResponse userResponse = new UserResponse();
			userResponse.setUserID(user.getUserId());
			userResponse.setUserName(user.getUserName());
			userResponse.setEmail(user.getEmail());
			userResponse.setCreatedAt(user.getCreatedAt());
			userResponse.setLastModifiedAt(user.getLastModifiedAt());
		return userResponse;
	}
	
	private User MapToUserEntity(UserRequestDTO userRequest, User user) {
		user.setEmail(userRequest.getEmail());
		user.setPassword(pass.encode(userRequest.getPassword()));
		user.setUserName(userRequest.getUserName());
		return user;
	}
	
}
