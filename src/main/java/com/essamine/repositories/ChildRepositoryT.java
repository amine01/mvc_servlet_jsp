package com.essamine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.essamine.entities.Child;
import com.essamine.entities.Single;

public interface ChildRepositoryT extends JpaRepository<Child, Long>{

}
