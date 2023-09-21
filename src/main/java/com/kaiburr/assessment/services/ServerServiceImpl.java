package com.kaiburr.assessment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaiburr.assessment.entity.Server;
import com.kaiburr.assessment.repository.ServerRepository;

@Service
public class ServerServiceImpl implements ServerService{

//	private static final String String = null;
	@Autowired
	ServerRepository serverRepo;
	
	@Override
	public List<Server> findAll() {
		return serverRepo.findAll();
	}
	
	@Override
    public void deleteServerByID(String id) {
        serverRepo.deleteById(id);
    }
	
	@Override
    public Optional<Server> findServerByID(String id) {
        return serverRepo.findById(id);
    }
	
	@Override
	public List<Server> findServersByName(String name){
		return serverRepo.findServersByName(name);
	}
	
	
//	@Override
//	public List<Server> findByNameContaining(String name){
//		return serverRepo.findByNameContaining(name);
//	}
//	@Override
//	public List<Server> findById(){
//		return serverRepo.findById();
//	}

	@Override
	public Server saveOrUpdateServer(Server server) {
		// TODO Auto-generated method stub
		return serverRepo.save(server);
	}

}
