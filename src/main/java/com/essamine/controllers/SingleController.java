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
import com.essamine.entities.Single;
import com.essamine.repositories.SingleRepositoryT;

@Controller
public class SingleController {

	@Autowired
	SingleRepositoryT singleRepositoryT;

	@RequestMapping(value = "/singles", method = RequestMethod.GET)
	public String getSingles(Model model) {
		model.addAttribute("singles", singleRepositoryT.findAll());
		return "single/list";
	}

	@RequestMapping(value = "/single", method = RequestMethod.GET, params = "add")
	public String getSingleAdd() {
		return "single/add";
	}

	@RequestMapping(value = "/single", method = RequestMethod.GET, params = "edit")
	public String getSingleEdit(@RequestParam long id, Model model) {
		model.addAttribute("single", singleRepositoryT.findOne(id));
		return "single/edit";
	}

	@RequestMapping(value = "/single", method = RequestMethod.GET, params = "delete")
	public String deleteSingle(@RequestParam long id, Model model) {
		singleRepositoryT.delete(id);
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

	@RequestMapping(value = "/single", params = "add", method = RequestMethod.POST)
	protected String addSingle(@RequestParam String passportnumber, @RequestParam String valid_date,
			@RequestParam String firstname, @RequestParam String lastname, @RequestParam String dob) {

		Passport passport = new Passport(passportnumber, convertToSqlDate(valid_date));
		Single single = new Single(firstname, lastname, convertToSqlDate(dob), passport);

		single = singleRepositoryT.save(single);

		return "redirect:persons";
	}

	@RequestMapping(value = "/single", params = "edit", method = RequestMethod.POST)
	protected String editSingle(@RequestParam long id, @RequestParam String passportnumber,
			@RequestParam String valid_date, @RequestParam String firstname, @RequestParam String lastname,
			@RequestParam String dob) {
		Single single = singleRepositoryT.findOne(id);
		Passport passport = single.getPassport();

		single.setFirstname(firstname);
		single.setLastname(lastname);
		single.setDob(convertToSqlDate(dob));

		passport.setPassportNumber(passportnumber);
		passport.setValid_date(convertToSqlDate(valid_date));

		single = singleRepositoryT.save(single);

		return "redirect:persons";
	}
}
