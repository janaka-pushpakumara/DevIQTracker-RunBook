package com.iit.deviqtracker.projectservice.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.deviqtracker.projectservice.dto.GitWeekCommitCountDTO;
import com.iit.deviqtracker.projectservice.dto.common.ResponseDTO;
import com.iit.deviqtracker.projectservice.dto.common.SummaryDTO;
import com.iit.deviqtracker.projectservice.dto.common.WeekCommitActivitySummaryDTO;
import com.iit.deviqtracker.projectservice.entity.CommitActivity;
import com.iit.deviqtracker.projectservice.entity.CommitCount;
import com.iit.deviqtracker.projectservice.repository.CommitActiviryRepository;
import com.iit.deviqtracker.projectservice.repository.CommitCountRepository;

@Service
public class GitActivityService {

	@Autowired
	private GitService gitServcie;

	@Autowired
	private CommitCountRepository commitCountRepository;

	@Autowired
	private CommitActiviryRepository commitActiviryRepository;

	public ResponseDTO handleWeekCommitCountSummary(String owner, String repo, String refresh) {

		String collection_id = owner + repo;
		GitWeekCommitCountDTO weekCommitCount = null;

		try {
			if(Boolean.valueOf(refresh)){
				weekCommitCount = gitServcie.getWeeklyCommitCount(owner, repo);
			}

			if (weekCommitCount != null && !weekCommitCount.getAll().isEmpty()) {
				// save to db
				commitCountRepository.save(new CommitCount(collection_id, weekCommitCount));
			}

		} catch (Exception e) {
			System.out.println("cant save commit count in DB, commit count list is NULL " + e);
		}

		try {

			if (weekCommitCount == null) {
				Optional<CommitCount> data = commitCountRepository.findById(collection_id);
				System.out.println(data);
				weekCommitCount = data.get().getData();

				if (!data.isPresent()) {
					return new ResponseDTO(null, "error", 0, "No records in DB");
				}
			}

		} catch (Exception e) {
			System.out.println("cant retrive data for commit_count table in DB : " + e);
			return new ResponseDTO(null, "error", 0, e.getMessage());
		}

		List<Integer> allCommitCount = weekCommitCount.getAll();
		List<Integer> ownerCommitCount = weekCommitCount.getOwner();
		DecimalFormat df = new DecimalFormat("#.##");

		ArrayList<SummaryDTO> weekSummaryOfCommitCountDTOList = new ArrayList<>();

		try {
			for (int i = 0; allCommitCount.size() > i; i++) {
				SummaryDTO weekSummaryOfCommitCountDTO = new SummaryDTO();
				double count1 = allCommitCount.get(i);
				double count2 = ownerCommitCount.get(i);
				double coutn3 = count1 - count2;

				double cal_week_percentage = 0;
				if (count1 != 0) {
					cal_week_percentage = (count2 / count1) * 100;
					double rounedValue = Double.valueOf(df.format(cal_week_percentage));
					weekSummaryOfCommitCountDTO.setCommitPercentage(String.valueOf(rounedValue));
				}
				weekSummaryOfCommitCountDTO.setOwnerId(owner);
				weekSummaryOfCommitCountDTO.setRepoId(repo);
				weekSummaryOfCommitCountDTO.setWeekId(String.valueOf(allCommitCount.size() - i));
				weekSummaryOfCommitCountDTO.setCommitCountAll(String.valueOf(Math.round(count1)));
				weekSummaryOfCommitCountDTO.setCommitCountOwner(String.valueOf(Math.round(count2)));
				weekSummaryOfCommitCountDTOList.add(weekSummaryOfCommitCountDTO);

			}
			Collections.reverse(weekSummaryOfCommitCountDTOList);

			return new ResponseDTO(weekSummaryOfCommitCountDTOList, "success", 1, "");

		} catch (Exception e) {
			return new ResponseDTO(null, "error", 0, e.getMessage());
		}

	}

	public ResponseDTO handleWeekCommitActivitySummary(String owner, String repo, String refresh) {

		ArrayList<Object> weekCommitActivityList = null;
		String collection_id = owner + repo;

		try {
			if(Boolean.valueOf(refresh)){
				weekCommitActivityList = gitServcie.getWeeklyCommitActivities(owner, repo);
			}
			if (weekCommitActivityList != null && !weekCommitActivityList.isEmpty()) {
				// save to db
				commitActiviryRepository.save(new CommitActivity(collection_id, weekCommitActivityList));
			}

		} catch (Exception e) {
			System.out.println("cant save commit count in DB, Activity list is NULL " + e);
		}

		try {

			if (weekCommitActivityList == null || weekCommitActivityList.isEmpty()) {
				Optional<CommitActivity> data = commitActiviryRepository.findById(collection_id);
				System.out.println(data);
				weekCommitActivityList = data.get().getData();

				if (!data.isPresent()) {
					return new ResponseDTO(null, "error", 0, "No records in DB");
				}
			}

		} catch (Exception e) {
			System.out.println("cant retrive data for commit_activity table in DB : " + e);
			return new ResponseDTO(null, "error", 0, e.getMessage());
		}

		ArrayList<WeekCommitActivitySummaryDTO> weekCommitActivitySummaryDTOList = new ArrayList<>();

		DecimalFormat df = new DecimalFormat("#.##");

		try {
			for (Object obj : weekCommitActivityList) {
				ArrayList<Integer> activity = (ArrayList<Integer>) obj;
				int weekID = activity.get(0);
				double addition = activity.get(1);
				double deletion = Math.abs(activity.get(2));
				WeekCommitActivitySummaryDTO weekCommitActivitySummaryDTO = new WeekCommitActivitySummaryDTO();
				weekCommitActivitySummaryDTO.setOwnerId(owner);
				weekCommitActivitySummaryDTO.setRepoId(repo);
				weekCommitActivitySummaryDTO.setWeekId(String.valueOf(new Date((long) weekID * 1000)));
				weekCommitActivitySummaryDTO.setAdditionCount(String.valueOf(addition));
				weekCommitActivitySummaryDTO.setDeletionCount(String.valueOf(deletion));
				if (addition != 0) {
					double ratio = deletion / addition;
					double rounedRatioValue = Double.valueOf(df.format(ratio));
					weekCommitActivitySummaryDTO.setRatio(String.valueOf(rounedRatioValue));
				}
				weekCommitActivitySummaryDTOList.add(weekCommitActivitySummaryDTO);
			}
			Collections.reverse(weekCommitActivitySummaryDTOList);
			return new ResponseDTO(weekCommitActivitySummaryDTOList, "success", 1, "");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDTO(null, "error", 0, e.getMessage());
		}

	}

}
