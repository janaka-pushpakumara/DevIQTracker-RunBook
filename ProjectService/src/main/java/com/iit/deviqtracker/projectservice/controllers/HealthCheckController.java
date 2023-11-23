package com.iit.deviqtracker.projectservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthCheckController {

	@GetMapping("info")
	public boolean checkHeartBeat() {
		return true;
	}

}
