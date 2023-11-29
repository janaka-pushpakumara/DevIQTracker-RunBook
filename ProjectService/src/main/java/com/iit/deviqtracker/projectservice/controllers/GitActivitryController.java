package com.iit.deviqtracker.projectservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.iit.deviqtracker.projectservice.dto.common.ResponseDTO;
import com.iit.deviqtracker.projectservice.dto.common.SummaryDTO;
import com.iit.deviqtracker.projectservice.service.GitActivityService;
import com.iit.deviqtracker.projectservice.service.GitService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class GitActivitryController {
	
	@Autowired
	private GitActivityService activityService;
	

	@GetMapping("/dashboard/{owner}/{repo}/week/commit/count")
	public ResponseDTO weekCommitCountSummary(@PathVariable("owner") String owner, @PathVariable("repo") String repo) {
		return activityService.handleWeekCommitCountSummary(owner, repo);
	}
	
	@GetMapping("/dashboard/{owner}/{repo}/week/commit/activity")
	public ResponseDTO weekCommitActivitySummary(@PathVariable("owner") String owner, @PathVariable("repo") String repo) {
		return activityService.handleWeekCommitActivitySummary(owner, repo);
	}

}
