package com.iit.deviqtracker.projectservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iit.deviqtracker.projectservice.dto.common.ResponseDTO;
import com.iit.deviqtracker.projectservice.dto.common.SummaryDTO;
import com.iit.deviqtracker.projectservice.service.GitActivityService;
import com.iit.deviqtracker.projectservice.service.GitService;

@RestController
public class GitActivitryController {
	
	@Autowired
	private GitActivityService activityService;
	
	//get weekly commit
	@GetMapping("/dashboard/{owner}/{repo}/week/commit/count")
	public ResponseDTO weekCommitCountSummary(@PathVariable("owner") String owner, @PathVariable("repo") String repo, @RequestParam(defaultValue = "false") String refresh) {
		return activityService.handleWeekCommitCountSummary(owner, repo, refresh);
	}

	//get commit activity
	@GetMapping("/dashboard/{owner}/{repo}/week/commit/activity")
	public ResponseDTO weekCommitActivitySummary(@PathVariable("owner") String owner, @PathVariable("repo") String repo, @RequestParam(defaultValue = "false") String refresh) {
		return activityService.handleWeekCommitActivitySummary(owner, repo, refresh);
	}

}
