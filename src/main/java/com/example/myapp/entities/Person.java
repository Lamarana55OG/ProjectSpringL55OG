package com.example.myapp.entities;

import javax.persistence.*;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String name;
	private String firstName;
	private int age;
	
	public Person() {
		super();
	}
		
	public Person(int id, String name, String firstName, int age) {
		super();
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.age = age;
	}
	
	public Person(String name, String firstName, int age) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.age = age;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
}
