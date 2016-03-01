package com.essamine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	

}