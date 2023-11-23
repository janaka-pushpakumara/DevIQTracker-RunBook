package com.iit.deviqtracker.oauthservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
	
	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}
	
	public void validateToken(String token) {
		jwtService.validateToken(token);
	}

}
