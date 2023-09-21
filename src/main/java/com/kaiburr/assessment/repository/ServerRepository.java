package com.kaiburr.assessment.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kaiburr.assessment.entity.Server;


public interface ServerRepository extends MongoRepository<Server, String> {
    
	List<Server> findServersByName(String name);
}

