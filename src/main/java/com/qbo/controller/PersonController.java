package com.qbo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qbo.service.PersonService;
import com.qbo.exception.ResourceNotFoundException;
import com.qbo.model.Person;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/person")
	public ResponseEntity<List<Person>> getAllPersons(){
		List<Person> persons = new ArrayList<Person>();
		personService.getAllPerons().forEach(persons::add);
		if(persons.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(persons, HttpStatus.OK);
	}
	
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable("id") Integer id) 
			throws ResourceNotFoundException 
	{
		Person person = personService.findById(id)
				.orElseThrow(() -> new 
						ResourceNotFoundException("Not found person with id = "+ id));
		return new ResponseEntity<>(person, HttpStatus.OK);
		
	}
	
	@PostMapping("/person")
	public ResponseEntity<Person> createPerson(@RequestBody Person person){
		Person _person = personService.save(person);
		return new ResponseEntity<>(person, HttpStatus.CREATED);
	}

}
