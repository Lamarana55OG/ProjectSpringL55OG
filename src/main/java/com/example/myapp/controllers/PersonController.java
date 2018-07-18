package com.example.myapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.dao.PersonRepository;
import com.example.myapp.entities.Person;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/person")
public class PersonController {
	
	@Autowired
	PersonRepository personRepository;
	
	@GetMapping
	public List<Person> index(){
		return personRepository.findAll();
	}
	
	@PostMapping
	public Person save(@RequestBody Person person) {
		return personRepository.save(person);
	}
	
	@GetMapping("{id}")
	public Person show(@PathVariable int id) {
		Person person = new Person();
		person=personRepository.findById(id);
		if(person != null) {
			return person;
		}else {
			return null;
		}
	}
	
	@PutMapping("{id}")
	public Person update(@PathVariable int id, @RequestBody Person person) {
		person.setId(id);
		return personRepository.save(person);
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable int id) {
		Person person = personRepository.findById(id);
		personRepository.delete(person);
		return "Suppression effectuer ! ";
	}
	
	@GetMapping("chercher")
	public Page<Person> chercher(
			@RequestParam(name="mc", defaultValue="")String mc, 
			@RequestParam(name="page", defaultValue="0") int page, 
			@RequestParam(name="size", defaultValue="10")int size){
		return personRepository.chercher("%"+mc+"%", new PageRequest(page, size));
	}
}
