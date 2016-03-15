package com.essamine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essamine.entities.Person;
import com.essamine.repositories.PersonRepositoryT;

@Controller
public class PersonController {

	@Autowired
	PersonRepositoryT personRepositoryT;

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String getPersons(Model model) {
		model.addAttribute("persons", personRepositoryT.findAll());
		return "person/list";
	}

	@RequestMapping(value = "/persons", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody List<Person> getPersons() {
		return personRepositoryT.findAll();
	}

}