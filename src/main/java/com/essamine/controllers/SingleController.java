package com.essamine.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.essamine.entities.Passport;
import com.essamine.entities.Single;
import com.essamine.repositories.MarriedRepositoryT;
import com.essamine.repositories.SingleRepositoryT;

@Controller
public class SingleController {
	@Autowired
	SingleRepositoryT singleRepositoryT;
	@Autowired
	MarriedRepositoryT marriedRepositoryT;

	@RequestMapping(value = "/single", method = RequestMethod.GET)
	public String getSingleAdd(Model model) {

		model.addAttribute("single", new Single());
		// model.addAttribute("passport", new Passport());
		return "single/add";
	}

	@RequestMapping(value = "/single", method = RequestMethod.GET, params = "edit")
	public String getSingleEdit(@RequestParam long id, Model model) {
		model.addAttribute("single", singleRepositoryT.findOne(id));
		model.addAttribute("singlefs", singleRepositoryT.findAll());
		model.addAttribute("marriedfs", marriedRepositoryT.findAll());
		return "single/edit";
	}

	@RequestMapping(value = "/single", method = RequestMethod.POST, params = "delete")
	public String deleteSingle(@RequestParam long id, Model model) {
		singleRepositoryT.delete(id);
		return "redirect:persons";
	}

	@RequestMapping(value = "/single", method = RequestMethod.GET, params = "view")
	public String getViewSingle(@RequestParam long id, Model model) {
		model.addAttribute("single", singleRepositoryT.findOne(id));
		return "single/view";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "passport.valid_date", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/single", params = "add", method = RequestMethod.POST)
	protected String addSingle(@Valid Single single, BindingResult bResult) {
		if (bResult.hasErrors()) {
			return "single/add";

		}
		single = singleRepositoryT.save(single);
		return "redirect:persons";
	}

	@RequestMapping(value = "/single", params = "edit", method = RequestMethod.POST)
	protected String editSingle(@RequestParam long id, @RequestParam long marriedf, @RequestParam long singlef,
			@RequestParam String passportnumber, @RequestParam String valid_date, @RequestParam String firstname,
			@RequestParam String lastname, @RequestParam String dob) {
		Single single = singleRepositoryT.findOne(id);
		Passport passport = single.getPassport();
		single.setFirstname(firstname);
		single.setLastname(lastname);
		single.setDob(convertToSqlDate(dob));
		single.setSingleFriend(singleRepositoryT.findOne(singlef));
		single.setMarriedFriend(marriedRepositoryT.findOne(marriedf));
		passport.setPassportnumber(passportnumber);
		passport.setValid_date(convertToSqlDate(valid_date));
		single = singleRepositoryT.save(single);
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
}
