package com.iit.deviqtracker.projectservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.deviqtracker.projectservice.client.GitClient;
import com.iit.deviqtracker.projectservice.dto.GitWeekCommitCountDTO;
import com.iit.deviqtracker.projectservice.dto.GitYearCommitDTO;
import com.iit.deviqtracker.projectservice.dto.contributors.GitContributorsDTO;

@Service
public class GitService {

	private final String GIT_TOKEN = "Bearer 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";

	@Autowired
	private GitClient client;

	public List<GitContributorsDTO> getContributors(String owner, String repo) {
		return client.getContributors(GIT_TOKEN, owner, repo);
	}

	public List<GitYearCommitDTO> getGitYearCommitActivities(String owner, String repo) {
		return client.getYearCommitsActivities(GIT_TOKEN, owner, repo);
	}

	public ArrayList<Object> getWeeklyCommitActivities(String owner, String repo) {
		return client.getWeeklyCommitsActivities(GIT_TOKEN, owner, repo);
	}

	public GitWeekCommitCountDTO getWeeklyCommitCount(String owner, String repo) {
		return client.getWeeklyCommitCount(GIT_TOKEN, owner, repo);
	}

	public ArrayList<Object> getHourlyCommitCount(String owner, String repo) {
		return client.getHourlyCommitCount(GIT_TOKEN, owner, repo);
	}

}
