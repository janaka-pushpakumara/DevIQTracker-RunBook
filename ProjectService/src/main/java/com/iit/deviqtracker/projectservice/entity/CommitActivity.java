package com.iit.deviqtracker.projectservice.entity;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.iit.deviqtracker.projectservice.dto.GitWeekCommitCountDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "commit_activity")
public
 class CommitActivity {

	@Id
	private String id;
	private ArrayList<Object> data;
	
}