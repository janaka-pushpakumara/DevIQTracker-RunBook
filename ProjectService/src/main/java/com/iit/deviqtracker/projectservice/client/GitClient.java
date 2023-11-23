package com.iit.deviqtracker.projectservice.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.iit.deviqtracker.projectservice.dto.GitWeekCommitCountDTO;
import com.iit.deviqtracker.projectservice.dto.GitYearCommitDTO;
import com.iit.deviqtracker.projectservice.dto.contributors.GitContributorsDTO;

@FeignClient(url = "https://api.github.com", name = "GIT-CLIENT")
public interface GitClient {

	@GetMapping("/repos/{owner}/{repo}/stats/contributors")
	public List<GitContributorsDTO> getContributors(
			@RequestHeader(value = "Authorization", required = true) String authorization,
			@PathVariable("owner") String owner, @PathVariable("repo") String repo);

	@GetMapping("/repos/{owner}/{repo}/stats/commit_activity")
	public List<GitYearCommitDTO> getYearCommitsActivities(
			@RequestHeader(value = "Authorization", required = true) String authorization,
			@PathVariable("owner") String owner, @PathVariable("repo") String repo);

	@GetMapping("/repos/{owner}/{repo}/stats/code_frequency")
	public ArrayList<Object> getWeeklyCommitsActivities(
			@RequestHeader(value = "Authorization", required = true) String authorization,
			@PathVariable("owner") String owner, @PathVariable("repo") String repo);

	@GetMapping("/repos/{owner}/{repo}/stats/participation")
	public GitWeekCommitCountDTO getWeeklyCommitCount(
			@RequestHeader(value = "Authorization", required = true) String authorization,
			@PathVariable("owner") String owner, @PathVariable("repo") String repo);

	@GetMapping("/repos/{owner}/{repo}/stats/punch_card")
	public ArrayList<Object> getHourlyCommitCount(
			@RequestHeader(value = "Authorization", required = true) String authorization,
			@PathVariable("owner") String owner, @PathVariable("repo") String repo);

}
