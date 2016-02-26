package com.essamine.controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	protected void postPerson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("add") != null) {

			Passport passport = new Passport(req.getParameter("passportnumber"),
					convertToSqlDate(req.getParameter("valid_date")));

			Person person = new Person(req.getParameter("firstname"), req.getParameter("lastname"),
					convertToSqlDate(req.getParameter("dob")), passport);

			personRepositoryT.save(person);

			resp.sendRedirect("/helloProjectWeb/persons");

		} else if (req.getParameter("edit") != null) {
			System.out.println("POST edit" + req.getParameter("id"));
			long id = Long.parseLong(req.getParameter("id"));

			Person person = personRepositoryT.findOne(id);
			Passport passport = person.getPassport();

			passport.setPassportNumber(req.getParameter("passportnumber"));
			passport.setValid_date(convertToSqlDate(req.getParameter("valid_date")));

			person.setFirstname(req.getParameter("firstname"));
			person.setLastname(req.getParameter("lastname"));
			person.setDob(convertToSqlDate(req.getParameter("dob")));
			person.setPassport(passport);

			personRepositoryT.save(person);

			req.setAttribute("persons", personRepositoryT.findAll());
			// RequestDispatcher view =
			// req.getRequestDispatcher("view/person/list.jsp");
			// view.forward(req, resp);
			resp.sendRedirect("/helloProjectWeb/persons");

		}

	}
}
