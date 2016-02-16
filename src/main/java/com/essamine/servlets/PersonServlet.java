package com.essamine.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.essamine.entities.Passport;
import com.essamine.entities.Person;
import com.essamine.repositories.PassportRepository;
import com.essamine.repositories.PersonRepository;

@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final PassportRepository passportRepository = new PassportRepository();
	final PersonRepository personRepository = new PersonRepository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("GET" + req.getParameter("action"));

		if (req.getParameter("add") != null) {
			req.getRequestDispatcher("jsp/add_person.jsp").forward(req, resp);
		} else {
			try {
				Person person = personRepository.find(Long.parseLong(req.getParameter("id")));
				Passport passport = passportRepository.find(person.getPassportID());
				req.setAttribute("person", person);
				req.setAttribute("passport", passport);
				req.getRequestDispatcher("jsp/view_person.jsp").forward(req, resp);

			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("POST" + req.getParameter("action"));

		SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy");
		Date sqlDate = null;
		try {
			sqlDate = new Date(format.parse(req.getParameter("valid_date")).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (req.getParameter("add") != null) {
			try {
				Passport passport = new Passport(req.getParameter("passportnumber"), sqlDate);

				passportRepository.create(passport);

				Person person = new Person(req.getParameter("firstname"), req.getParameter("lastname"), sqlDate,
						passport.getId());

				personRepository.create(person);

				resp.sendRedirect("/helloProjectWeb/persons");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
