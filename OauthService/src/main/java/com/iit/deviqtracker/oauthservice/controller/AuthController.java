package com.iit.deviqtracker.oauthservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iit.deviqtracker.oauthservice.dto.AuthRequestDto;
import com.iit.deviqtracker.oauthservice.entity.UserCredential;
import com.iit.deviqtracker.oauthservice.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public String addNewUser(@RequestBody UserCredential user) {
		return authService.saveUser(user);
	}
	
	@PostMapping("/token")
	public String getToken(@RequestBody AuthRequestDto authRequest) {
		return authService.generateToken(authRequest.getUsername());
	}
	
	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token) {
		authService.validateToken(token);
		return "Token is valid";
	}
	
	
}
