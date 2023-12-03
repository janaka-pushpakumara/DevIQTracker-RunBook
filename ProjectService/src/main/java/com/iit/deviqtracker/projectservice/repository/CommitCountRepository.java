package com.iit.deviqtracker.projectservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.iit.deviqtracker.projectservice.entity.CommitCount;


@Repository
public interface CommitCountRepository extends MongoRepository<CommitCount, String>{

}


