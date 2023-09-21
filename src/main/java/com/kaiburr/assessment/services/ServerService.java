package com.kaiburr.assessment.services;

import java.util.List;
import java.util.Optional;

import com.kaiburr.assessment.entity.Server;


public interface ServerService {

	List<Server> findAll();
//	List<Server> findById();
	Optional<Server> findServerByID(String id);
	
	List<Server>findServersByName(String name);
	
	 Server saveOrUpdateServer(Server server);
	 void deleteServerByID(String id);
	 
}
