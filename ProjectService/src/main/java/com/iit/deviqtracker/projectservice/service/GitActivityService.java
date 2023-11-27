package com.iit.deviqtracker.projectservice.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.deviqtracker.projectservice.dto.GitWeekCommitCountDTO;
import com.iit.deviqtracker.projectservice.dto.common.ResponseDTO;
import com.iit.deviqtracker.projectservice.dto.common.SummaryDTO;
import com.iit.deviqtracker.projectservice.dto.common.WeekCommitActivitySummaryDTO;

@Service
public class GitActivityService {

	@Autowired
	private GitService gitServcie;

	public ResponseDTO handleWeekCommitCountSummary(String owner, String repo) {

		GitWeekCommitCountDTO weekCommitCount = gitServcie.getWeeklyCommitCount(owner, repo);
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
				weekSummaryOfCommitCountDTO.setWeekId(String.valueOf(i));
				weekSummaryOfCommitCountDTO.setCommitCountAll(String.valueOf(Math.round(count1)));
				weekSummaryOfCommitCountDTO.setCommitCountOwner(String.valueOf(Math.round(count2)));
				weekSummaryOfCommitCountDTOList.add(weekSummaryOfCommitCountDTO);

			}
			return new ResponseDTO(weekSummaryOfCommitCountDTOList, "success", 1, "");

		} catch (Exception e) {
			return new ResponseDTO(null, "error", 0, e.getMessage());
		}

	}

	public ResponseDTO handleWeekCommitActivitySummary(String owner, String repo) {

		ArrayList<Object> weekCommitActivityList = gitServcie.getWeeklyCommitActivities(owner, repo);
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
				weekCommitActivitySummaryDTO.setWeekId(String.valueOf(weekID));
				weekCommitActivitySummaryDTO.setAdditionCount(String.valueOf(addition));
				weekCommitActivitySummaryDTO.setDeletionCount(String.valueOf(deletion));
				if (addition != 0) {
					double ratio = deletion / addition;
					double rounedRatioValue = Double.valueOf(df.format(ratio));
					weekCommitActivitySummaryDTO.setRatio(String.valueOf(rounedRatioValue));
				}
				weekCommitActivitySummaryDTOList.add(weekCommitActivitySummaryDTO);
			}
			return new ResponseDTO(weekCommitActivitySummaryDTOList, "success", 1, "");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDTO(null, "error", 0, e.getMessage());
		}

	}

}
