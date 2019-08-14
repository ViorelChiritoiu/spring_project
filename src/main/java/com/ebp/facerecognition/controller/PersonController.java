package com.ebp.facerecognition.controller;

import com.ebp.facerecognition.model.Person;
import com.ebp.facerecognition.repository.PersonRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Api(value = "Employee Management System")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @ApiOperation(value = "View a list of available persons", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 204, message = "No persons found"),
    })
    @GetMapping(value = "/persons", produces = "application/json")
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @GetMapping(value = "persons/id/{id:\\d+}")
    public Optional<Person> findById(@PathVariable Long id) {
        return personRepository.findById(id);
    }

   @GetMapping(value = "persons/email/{email}")
    public List<Person> findByEmail(@PathVariable String email) {
        return personRepository.findByEmail(email);
    }

}
