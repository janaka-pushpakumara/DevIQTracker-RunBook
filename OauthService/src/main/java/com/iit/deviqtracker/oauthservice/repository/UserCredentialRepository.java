package com.iit.deviqtracker.oauthservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iit.deviqtracker.oauthservice.entity.UserCredential;

public interface UserCredentialRepository extends MongoRepository<UserCredential, Integer>{

}
