package com.iit.deviqtracker.oauthservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.iit.deviqtracker.oauthservice.dto.ResponseDTO;
import com.iit.deviqtracker.oauthservice.dto.UserDetailsDto;
import com.iit.deviqtracker.oauthservice.entity.UserCredential;
import com.iit.deviqtracker.oauthservice.repository.UserCredentialRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserCredentialRepository userCredRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	public String saveUser(UserCredential userCredential) {
		userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
		userCredRepository.save(userCredential);
		return "Successfully user added to the system";
	}
	
	public ResponseDTO generateToken(UserDetailsDto user) {
		ResponseDTO responseDTO = new ResponseDTO();
		user.setToken(jwtService.generateToken(user.getUsername()));
		responseDTO.setMessage("success");
		responseDTO.setStatus(1);
		responseDTO.setData(user);
		return responseDTO;
	}
	
	public void validateToken(String token) {
		jwtService.validateToken(token);
	}
	
	public UserCredential getUserCredentialByUsername(String userName) {
		return userCredRepository.findByName(userName);
	}

}
