package com.iit.deviqtracker.projectservice.service;

import com.iit.deviqtracker.projectservice.dto.GitWeekCommitCountDTO;
import com.iit.deviqtracker.projectservice.entity.CommitActivity;
import com.iit.deviqtracker.projectservice.entity.CommitCount;
import com.iit.deviqtracker.projectservice.repository.CommitActiviryRepository;
import com.iit.deviqtracker.projectservice.repository.CommitCountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SchedulerService {

    private final String owner = "janaka-pushpakumara";
    private final String repo = "DevIQTracker";
    Logger log = LoggerFactory.getLogger(SchedulerService.class);
    @Autowired
    private GitService gitServcie;
    @Autowired
    private CommitCountRepository commitCountRepository;
    @Autowired
    private CommitActiviryRepository commitActiviryRepository;

    @Scheduled(fixedRate = 60000)
    private void scheduleWeekCommitCount() {
        String collection_id = owner + repo;
        try {
            GitWeekCommitCountDTO weekCommitCount = gitServcie.getWeeklyCommitCount(owner, repo);
            log.info("-----SCHEDULER: commit count data fetching success.");

            if (weekCommitCount != null && !weekCommitCount.getAll().isEmpty()) {
                // save to db
                commitCountRepository.save(new CommitCount(collection_id, weekCommitCount));
                log.info("Save commit count data on DB successful.");
            }

        } catch (Exception e) {
            log.error("Cant save commit count in DB." + e);
        }
    }

    @Scheduled(fixedRate = 60000)
    private void scheduleWeekCommitActivity() {
        String collection_id = owner + repo;
        try {
            ArrayList<Object> weekCommitActivityList = gitServcie.getWeeklyCommitActivities(owner, repo);
            log.info("-----SCHEDULER: activity data fetching success.");

            if (weekCommitActivityList != null && !weekCommitActivityList.isEmpty()) {
                // save to db
                commitActiviryRepository.save(new CommitActivity(collection_id, weekCommitActivityList));
                log.info("Save activity data on DB successful. List size:" + weekCommitActivityList.size());
            }

        } catch (Exception e) {
            log.error("Cant save commit activities in DB." + e);
        }
    }


}
