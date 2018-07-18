package com.example.myapp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.myapp.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	List<Person> findAll();
	Person findById(int id);
	@Query("select p from Person p where p.name like :x")
	public Page<Person> chercher(@Param("x") String mc, Pageable pageable ); 

}
