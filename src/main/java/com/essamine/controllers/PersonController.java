package com.essamine.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.essamine.entities.Passport;
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

	@RequestMapping(value = "/person", method = RequestMethod.GET, params = "add")
	public String getPersonAdd() {
		return "person/add";
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET, params = "edit")
	public String getPersonEdit(@RequestParam long id, Model model) {
		model.addAttribute("person", personRepositoryT.findOne(id));
		return "person/edit";
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET, params = "delete")
	public String deletePerson(@RequestParam long id, Model model) {
		personRepositoryT.delete(id);
		return "redirect:persons";

	}

	public Date convertToSqlDate(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy");// HH:mm:ss
		Date sqlDate = null;
		try {
			sqlDate = new Date(format.parse(dateString).getTime());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		return sqlDate;
	}

	// to spring-field

	@RequestMapping(value = "/person", params = "add", method = RequestMethod.POST)
	protected String addPerson(@RequestParam String passportnumber, @RequestParam String valid_date,
			@RequestParam String firstname, @RequestParam String lastname, @RequestParam String dob) {

		Passport passport = new Passport(passportnumber, convertToSqlDate(valid_date));
		Person person = new Person(firstname, lastname, convertToSqlDate(dob), passport);

		person = personRepositoryT.save(person);


		return "redirect:persons";
	}

	@RequestMapping(value = "/person", params = "edit", method = RequestMethod.POST)
	protected String editPerson(@RequestParam long id, @RequestParam String passportnumber,
			@RequestParam String valid_date, @RequestParam String firstname, @RequestParam String lastname,
			@RequestParam String dob) {
		Person person = personRepositoryT.findOne(id);
		Passport passport = person.getPassport();

		person.setFirstname(firstname);
		person.setLastname(lastname);
		person.setDob(convertToSqlDate(dob));

		passport.setPassportNumber(passportnumber);
		passport.setValid_date(convertToSqlDate(valid_date));

		person = personRepositoryT.save(person);

		return "redirect:persons";
	}
}

