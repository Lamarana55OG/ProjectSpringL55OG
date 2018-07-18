package com.example.myapp.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.myapp.dao.PersonRepository;
import com.example.myapp.entities.Person;
import com.github.javafaker.Faker;

@Service
public class TableSeeder implements CommandLineRunner{
	
	@Autowired
	PersonRepository personRepository;
	
	Faker faker = new Faker();
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		for(int i=0; i<5; i++) {
			
			Person person = new Person(faker.name().lastName(),faker.name().firstName(), faker.number().randomDigitNotZero());
			personRepository.save(person);
		}
	}
}
