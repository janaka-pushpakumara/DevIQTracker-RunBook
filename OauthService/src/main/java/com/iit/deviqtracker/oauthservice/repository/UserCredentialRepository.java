package com.iit.deviqtracker.oauthservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.iit.deviqtracker.oauthservice.entity.UserCredential;

@Repository
public interface UserCredentialRepository extends MongoRepository<UserCredential, String>{

}
