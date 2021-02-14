package com.example.restapiWithH2Integration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	public List<Person> getAllPerson() {
		List<Person> persons = new ArrayList<Person>();
		personRepository.findAll().forEach(person -> persons.add(person));
		return persons;
	}

	public Person getPersonById(int id) {
		return personRepository.findById(id).get();
	}

	public void SaveOrUpdate(Person person) {
		personRepository.save(person);
	}

	public void delete(int id) {
		personRepository.deleteById(id);
	}
}
