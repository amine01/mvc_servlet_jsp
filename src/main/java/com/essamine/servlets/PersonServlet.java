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
	final PassportRepository passportRepository = new PassportRepository();
	final PersonRepository personRepository = new PersonRepository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET");
		req.getRequestDispatcher("jsp/add_person.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST");
		// ############ date
		SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy");
		Date sqlDate = null;
		try {
			sqlDate = new Date(format.parse(req.getParameter("valid_date")).getTime());

			Passport passport = new Passport(req.getParameter("passportnumber"), sqlDate);

			passportRepository.create(passport);

			Person person = new Person(req.getParameter("firstname"), req.getParameter("lastname"), sqlDate,
					passport.getId());

			personRepository.create(person);
			resp.encodeRedirectURL("/helloProjectWeb/person");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
