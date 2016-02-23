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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.essamine.entities.Passport;
import com.essamine.entities.Person;
import com.essamine.repositories.PersonRepositoryT;

@Controller
public class PersonController {

	@Autowired
	PersonRepositoryT personRepositoryT;

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	protected void getPersons(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("persons", personRepositoryT.findAll());
		
		RequestDispatcher view = req.getRequestDispatcher("view/person/list.jsp");
		view.forward(req, resp);
		
		
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	protected void getPerson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("add") != null) {
			req.getRequestDispatcher("view/person/add.jsp").forward(req, resp);
		} else if (req.getParameter("edit") != null) {
			System.out.println("edit GET" + req.getParameter("id"));
			long id = Long.parseLong(req.getParameter("id"));

			Person person = personRepositoryT.findOne(id);
			req.setAttribute("person", person);
			req.getRequestDispatcher("view/person/edit.jsp").forward(req, resp);
		} else if (req.getParameter("delete") != null) {

			Person person = personRepositoryT.findOne(Long.parseLong(req.getParameter("id")));
			// Passport passport = person.getPassport();

			personRepositoryT.delete(person);
			// passportRepository.delete(passport);
			resp.sendRedirect("/helloProjectWeb/persons");
		} else {
			req.getRequestDispatcher("/helloProjectWeb/").forward(req, resp);

		}

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
			RequestDispatcher view = req.getRequestDispatcher("view/person/list.jsp");
			view.forward(req, resp);
			// resp.sendRedirect("/helloProjectWeb/persons");

		}

	}
}
