package com.essamine.controllers;

import java.sql.Date;
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

import com.essamine.entities.Married;
import com.essamine.repositories.MarriedRepositoryT;

@Controller
public class MarriedController {

	@Autowired
	MarriedRepositoryT marriedRepositoryT;

	@RequestMapping(value = "/married", method = RequestMethod.GET)
	public String getMarriedAdd(Model model) {
		model.addAttribute("married", new Married());
		return "married/add";
	}

	@RequestMapping(value = "/married", method = RequestMethod.GET, params = "edit")
	public String getMarriedEdit(@RequestParam long id, Model model) {
		model.addAttribute("married", marriedRepositoryT.findOne(id));
		return "married/edit";
	}

	@RequestMapping(value = "/married", method = RequestMethod.GET, params = "view")
	public String getMarriedView(@RequestParam long id, Model model) {
		model.addAttribute("married", marriedRepositoryT.findOne(id));
		return "married/view";
	}

	@RequestMapping(value = "/married", method = RequestMethod.POST, params = "delete")
	public String deleteMarried(@RequestParam long id, Model model) {
		marriedRepositoryT.delete(id);
		return "redirect:persons";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/married", params = "add", method = RequestMethod.POST)
	protected String addMarried(@Valid Married married, BindingResult bResult) {
		if (bResult.hasErrors()) {
			return "married/add";
		}
		married = marriedRepositoryT.save(married);
		return "redirect:persons";
	}

	@RequestMapping(value = "/married", params = "edit", method = RequestMethod.POST)
	protected String editMarried(@Valid Married married, BindingResult bResult) {
		if (bResult.hasErrors()) {
			return "married/edit";
		}
		Married marriedToEdit = marriedRepositoryT.findOne(married.getId());
		marriedToEdit.setFirstname(married.getFirstname());
		marriedToEdit.setLastname(married.getLastname());
		marriedToEdit.setDob(married.getDob());
		
		marriedRepositoryT.save(marriedToEdit);

		return "redirect:persons";
	}


}
