package com.iit.deviqtracker.projectservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.iit.deviqtracker.projectservice.dto.GitYearCommitDTO;
import com.iit.deviqtracker.projectservice.dto.contributors.GitContributorsDTO;
import com.iit.deviqtracker.projectservice.service.GitService;

@RestController("/repos")
public class GitController {

	@Autowired
	private GitService service;

	@GetMapping("/{owner}/{repo}/stats/contributors")
	public List<GitContributorsDTO> repoContributores(@PathVariable("owner") String owner,
			@PathVariable("repo") String repo) {
		return service.getContributors(owner, repo);
	}

	@GetMapping("/{owner}/{repo}/stats/commit_activity")
	public List<GitYearCommitDTO> yearCommitActivity(@PathVariable("owner") String owner,
			@PathVariable("repo") String repo) {
		return service.getGitYearCommitActivities(owner, repo);
	}

	@GetMapping("/{owner}/{repo}/stats/code_frequency")
	public ArrayList<Object> weeklyCommitActivity(@PathVariable("owner") String owner,
			@PathVariable("repo") String repo) {
		return service.getWeeklyCommitActivities(owner, repo);
	}

	@GetMapping("/{owner}/{repo}/stats/participation")
	public Object weekCommitCount(@PathVariable("owner") String owner, @PathVariable("repo") String repo) {
		return service.getWeeklyCommitCount(owner, repo);
	}

	@GetMapping("/{owner}/{repo}/stats/punch_card")
	public ArrayList<Object> hourlyCommitCount(@PathVariable("owner") String owner, @PathVariable("repo") String repo) {
		return service.getHourlyCommitCount(owner, repo);
	}
	
	
}