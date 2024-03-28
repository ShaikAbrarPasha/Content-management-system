package com.example.cms.service;

import org.springframework.http.ResponseEntity;

import com.example.cms.exception.UserAlreadyExistByEmailException;
import com.example.cms.model.User;
import com.example.cms.responseDTO.UserResponse;
import com.example.cms.userDTO.UserRequestDTO;
import com.example.cms.utility.ResponseStructure;

import jakarta.validation.Valid;

public interface UserService {

	public ResponseEntity<ResponseStructure<UserResponse>> registerUser(UserRequestDTO user) throws UserAlreadyExistByEmailException;

	public ResponseEntity<ResponseStructure<UserResponse>> deleteUser( int userId);

	public ResponseEntity<ResponseStructure<UserResponse>> findByUserId(int userId);



}
