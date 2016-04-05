package com.essamine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essamine.entities.Person;
import com.essamine.repositories.PersonRepositoryT;

@Controller
@Transactional
public class PersonController {

	@Autowired
	PersonRepositoryT personRepositoryT;

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String getPersons(Model model, @RequestParam(required = false) Integer page) {
		int recordPerPage = 3;

		int pageR = 1;

		if (page != null) {
			if (page <= 0)
				page = 1;
			pageR = page;
		}

		Page<Person> persons = personRepositoryT.findAll(new PageRequest(pageR - 1, recordPerPage));

		// Number Of Records
		int noOfRecords = personRepositoryT.findAll().size();
		
		// Number Of Pages
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordPerPage);

//		System.out.println("current page=" + pageR);
//		System.out.println("record page=" + recordPerPage);
//		System.out.println("number of page=" + noOfPages);

		model.addAttribute("persons", persons.getContent());
		model.addAttribute("currentPage", pageR);
		model.addAttribute("recordPerPage", recordPerPage);
		model.addAttribute("noOfPages", noOfPages);

		return "person/list";
	}

	@RequestMapping(value = "/persons", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Person> getPersons() {
		return personRepositoryT.findAll();
	}

}