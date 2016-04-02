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

import com.essamine.entities.Child;
import com.essamine.entities.Passport;
import com.essamine.repositories.ChildRepositoryT;
import com.essamine.repositories.MarriedRepositoryT;

@Controller
public class ChildController {

	@Autowired
	ChildRepositoryT childRepositoryT;

	@Autowired
	MarriedRepositoryT marriedRepositoryT;

	// @RequestMapping(value = "/childs", method = RequestMethod.GET)
	// public String getChilds(Model model) {
	// model.addAttribute("singles", singleRepositoryT.findAll());
	// return "single/list";
	// }

	@RequestMapping(value = "/child", method = RequestMethod.GET, params = "add")
	public String getChildAdd(@RequestParam long id, Model model) {
		model.addAttribute("married", marriedRepositoryT.findOne(id));
		return "child/add";
	}

	@RequestMapping(value = "/child", method = RequestMethod.GET, params = "edit")
	public String getChildEdit(@RequestParam long id, Model model) {
		model.addAttribute("child", childRepositoryT.findOne(id));
		return "child/edit";
	}

	@RequestMapping(value = "/child", method = RequestMethod.GET, params = "delete")
	public String deleteChild(@RequestParam long id) {
		Child child=childRepositoryT.findOne(id);
		childRepositoryT.delete(child);
		//model.addAttribute("married", marriedRepositoryT.findOne(id_ma));
		// return "redirect:persons";
		//return "married/view";
		return "redirect:married?id="+child.getMarried().getId()+"&view";
	}

	@RequestMapping(value = "/child", method = RequestMethod.GET, params = "view")
	public String getViewChild(@RequestParam long id, Model model) {
		model.addAttribute("child", childRepositoryT.findOne(id));
		return "child/view";

	}

	// to spring-field

	@RequestMapping(value = "/child", params = "add", method = RequestMethod.POST)
	protected String addChild(@RequestParam String married_id, @RequestParam String firstname,
			@RequestParam String passportnumber, @RequestParam String valid_date, Model model) {

		Passport passport = new Passport(passportnumber, convertToSqlDate(valid_date));

		Child child = new Child(firstname, passport, marriedRepositoryT.findOne(Long.parseLong(married_id)));// married

		child = childRepositoryT.save(child);
		System.out.println("added child=" + child.getId());
		model.addAttribute("married", marriedRepositoryT.findOne(Long.parseLong(married_id)));
		return "married/view";
		// return "redirect:persons";
	}

	@RequestMapping(value = "/child", params = "edit", method = RequestMethod.POST)
	protected String editChild(@RequestParam long id, @RequestParam String firstname,@RequestParam String passportnumber,
			@RequestParam String valid_date) {
		Child child = childRepositoryT.findOne(id);
		Passport passport = child.getPassport();
		child.setFirstname(firstname);
		//child.setMarried(null);// TODO
		passport.setPassportNumber(passportnumber);
		passport.setValid_date(convertToSqlDate(valid_date));
		child.setPassport(passport);
		child = childRepositoryT.save(child);
		//married?id=1&view	return "redirect:persons";
		return "redirect:married?id="+child.getMarried().getId()+"&view";
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
}
