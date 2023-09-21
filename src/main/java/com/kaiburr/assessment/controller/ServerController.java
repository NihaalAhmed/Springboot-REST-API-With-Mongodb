package com.kaiburr.assessment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kaiburr.assessment.entity.Server;
import com.kaiburr.assessment.repository.ServerRepository;
import com.kaiburr.assessment.services.ServerServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(tags = "ServerController", description = "A Server Controller to perform RESTful API using spring boot to perform the following methods:")
@RequestMapping("/servers")
public class ServerController {

    @Autowired
    private ServerServiceImpl serverServiceImpl;

    @GetMapping("/create")
    @ApiOperation(value = "CreateServer", notes = "This GET request is useful for querying and retrieving resources that match the specified criteria. It can be used to fetch resource details from the server based on framework, ID, language, or name filters. Make sure to provide valid values for the parameters to get accurate results.")
    public List<Server> getAllServers() {
        try {
            return serverServiceImpl.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve servers");
        }
    }

    @PostMapping("/create")
    @ApiOperation(value = "CreateServer", notes = "When you make a POST request to this endpoint, you provide data in the request body with the following parameters: framework (string): The framework associated with the new resource. id (string): A unique identifier for the new resource. language (string): The programming language used for the new resource. name (string): The name of the new resource.\r\n"
            + "Make sure to provide valid values for these parameters in the request body to create the new resource successfully.")
    public Server createServer(@RequestBody Server server) {
        try {
            return serverServiceImpl.saveOrUpdateServer(server);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create server");
        }
    }

    @PutMapping("/update")
    @ApiOperation(value = "UpdateServer", notes = "This GET request is useful for querying and retrieving resources that match the specified criteria. It can be used to fetch resource details from the server based on framework, ID, language, or name filters. Make sure to provide valid values for the parameters to get accurate results.")
    public Server updateServer(@RequestBody Server server) {
        try {
            return serverServiceImpl.saveOrUpdateServer(server);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update server");
        }
    }

    @GetMapping("/findByName")
    @ApiOperation(value = "getServerByName", notes = "Offers a detailed explanation of the findByName endpoint's purpose, which is to find a resource based on Name. parameters: Specifies the name parameter in the path, indicating that it's required and should be a string representing the name of the resource to be found.")
    public List<Server> getServersByName(@RequestParam(name = "name", required = false) String name) {
        try {
            return serverServiceImpl.findServersByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve servers by name");
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteServerById", notes = "Offers a detailed explanation of the DELETE endpoint's purpose, which is to delete a resource based on its unique identifier. parameters: Specifies the id parameter in the path, indicating that it's required and should be a string representing the unique identifier of the resource to be deleted..")
    public String deleteServer(@PathVariable String id) {
        try {
            Optional<Server> server = serverServiceImpl.findServerByID(id);
            if (server.isPresent()) {
                serverServiceImpl.deleteServerByID(id);
                return "Record Deleted Successfully.";
            } else {
                return "Id doesn't exist.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to delete server");
        }
    }
}
