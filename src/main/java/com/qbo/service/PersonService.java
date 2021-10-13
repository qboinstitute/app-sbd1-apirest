package com.qbo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qbo.model.Person;

@Service
public class PersonService {

	public List<Person> lstPersons = new ArrayList<>();
	
	public PersonService() {
		lstPersons.add(new Person(1, "Luis Angel", 34));
		lstPersons.add(new Person(2, "Felipe Caicedo", 34));
		lstPersons.add(new Person(3, "Brandon Jesus", 34));
		lstPersons.add(new Person(4, "Luiz Felipe", 34));
	}
	
	public List<Person> getAllPerons(){
		return lstPersons;
	}
	
	public Optional<Person> findById(Integer id){
		for(Person objperson : lstPersons) {
			if(objperson.getId().equals(id)) {
				return Optional.of(new Person(objperson.getId(), objperson.getName(), objperson.getAge()));
			}
		}
		return Optional.empty();
	}
	
	public Person save (Person person) {
		lstPersons.add(person);
		return person;
	}
	
}
