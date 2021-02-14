package com.example.restapiWithH2Integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/persons")
	public List<Person> getAllPerson(){
		return personService.getAllPerson();
	}
	
	@GetMapping("/persons/{id}")
	public Person getPersonById(@PathVariable("id") int id) {
		return personService.getPersonById(id);
	}
	
	@PostMapping("/persons")
	public int savePerson(@RequestBody Person person) {
		personService.SaveOrUpdate(person);
		return person.getId();
	}
	
	@DeleteMapping("/persons/{id}")
	public void deletePerson(@PathVariable("id") int id) {
		personService.delete(id);
	}
}
