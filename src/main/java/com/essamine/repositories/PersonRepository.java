package com.essamine.repositories;

import com.essamine.entities.Person;

public class PersonRepository extends Repository<Person> {
	public PersonRepository() {
		super(Person.class);
	}
}
