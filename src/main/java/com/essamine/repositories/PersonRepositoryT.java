package com.essamine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.essamine.entities.Person;

public interface PersonRepositoryT extends JpaRepository<Person, Long>{
	
//	List<Person> listAllPersons(Pageable pageable);
	

}
