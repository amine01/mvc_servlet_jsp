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

import com.essamine.entities.Married;
import com.essamine.repositories.MarriedRepositoryT;
import com.essamine.repositories.SingleRepositoryT;

@Controller
public class MarriedController {

	@Autowired
	MarriedRepositoryT marriedRepositoryT;

	// @RequestMapping(value = "/marrieds", method = RequestMethod.GET)
	// public String getMarrieds(Model model) {
	// model.addAttribute("marrieds", marriedRepositoryT.findAll());
	// return "married/list";
	// }

	@RequestMapping(value = "/married", method = RequestMethod.GET, params = "add")
	public String getMarriedAdd() {
		return "married/add";
	}

	@RequestMapping(value = "/married", method = RequestMethod.GET, params = "edit")
	public String getMarriedEdit(@RequestParam long id, Model model) {
		model.addAttribute("married", marriedRepositoryT.findOne(id));
		return "married/edit";
	}

	@RequestMapping(value = "/married", method = RequestMethod.GET, params = "delete")
	public String deleteMarried(@RequestParam long id, Model model) {
		marriedRepositoryT.delete(id);
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

	@RequestMapping(value = "/married", params = "add", method = RequestMethod.POST)
	protected String addMarried(@RequestParam String firstname, @RequestParam String lastname,
			@RequestParam String dob) {

		Married married = new Married(firstname, lastname, convertToSqlDate(dob), null);

		married = marriedRepositoryT.save(married);

		return "redirect:persons";
	}

	@RequestMapping(value = "/married", params = "edit", method = RequestMethod.POST)
	protected String editMarried(@RequestParam long id, @RequestParam String firstname, @RequestParam String lastname,
			@RequestParam String dob) {
		Married married = marriedRepositoryT.findOne(id);
		// Passport passport = married.getPassport();

		married.setFirstname(firstname);
		married.setLastname(lastname);
		married.setDob(convertToSqlDate(dob));

		married = marriedRepositoryT.save(married);

		return "redirect:persons";
	}
}
