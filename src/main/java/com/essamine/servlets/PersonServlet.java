package com.essamine.servlets;

import java.io.IOException;
import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.essamine.entities.Passport;
import com.essamine.entities.Person;
import com.essamine.repositories.PersonRepository;

@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//final PassportRepository passportRepository = new PassportRepository();
	final PersonRepository personRepository = new PersonRepository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("add") != null) {
			req.getRequestDispatcher("jsp/add_person.jsp").forward(req, resp);
		} else if (req.getParameter("edit") != null) {
			System.out.println("edit GET" + req.getParameter("id"));
			long id = Long.parseLong(req.getParameter("id"));
			Person person = personRepository.find(id);
			req.setAttribute("person", person);
			req.getRequestDispatcher("jsp/edit_person.jsp").forward(req, resp);
		} else if (req.getParameter("delete") != null) {

			Person person = personRepository.find(Long.parseLong(req.getParameter("id")));
			//Passport passport = person.getPassport();
			
			personRepository.delete(person);
			//passportRepository.delete(passport);
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("POST" + req.getParameter("action"));

		if (req.getParameter("add") != null) {

			Passport passport = new Passport(req.getParameter("passportnumber"),
					convertToSqlDate(req.getParameter("valid_date")));

			//passport = passportRepository.save(passport);

			Person person = new Person(req.getParameter("firstname"), req.getParameter("lastname"),
					convertToSqlDate(req.getParameter("dob")), passport);

			personRepository.save(person);

			resp.sendRedirect("/helloProjectWeb/persons");

		} else if (req.getParameter("edit") != null) {
			System.out.println("POST edit" + req.getParameter("id"));
			long id = Long.parseLong(req.getParameter("id"));

			Person person = personRepository.find(id);
			Passport passport = person.getPassport();

			passport.setPassportNumber(req.getParameter("passportnumber"));
			passport.setValid_date(convertToSqlDate(req.getParameter("valid_date")));
			//passport = passportRepository.save(passport);
			person.setFirstname(req.getParameter("firstname"));
			person.setLastname(req.getParameter("lastname"));
			person.setDob(convertToSqlDate(req.getParameter("dob")));
			person.setPassport(passport);
			
			personRepository.save(person);

			req.setAttribute("persons", personRepository.findAll());
			RequestDispatcher view = req.getRequestDispatcher("jsp/list_persons.jsp");
			view.forward(req, resp);
			// resp.sendRedirect("/helloProjectWeb/persons");

		}

	}
}
