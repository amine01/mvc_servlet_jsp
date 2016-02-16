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
		// System.out.println("GET" + req.getParameter("action"));

		if (req.getParameter("add") != null) {
			req.getRequestDispatcher("jsp/add_person.jsp").forward(req, resp);
		} else if (req.getParameter("edit") != null) {
			System.out.println("edit GET" + req.getParameter("id"));
			try {
				Person person = personRepository.find(Long.parseLong(req.getParameter("id")));
				Passport passport = passportRepository.find(person.getPassportID());
				req.setAttribute("person", person);
				req.setAttribute("passport", passport);
				req.getRequestDispatcher("jsp/edit_person.jsp").forward(req, resp);

			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (req.getParameter("delete") != null) {
			try {
				Person person = personRepository.find(Long.parseLong(req.getParameter("id")));
				Passport passport = passportRepository.find(person.getPassportID());

				personRepository.delete(person);
				passportRepository.delete(passport);
				resp.sendRedirect("/helloProjectWeb/persons");
			
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Date convertToSqlDate(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy");
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
			try {
				Passport passport = new Passport(req.getParameter("passportnumber"),
						convertToSqlDate(req.getParameter("valid_date")));

				passportRepository.create(passport);

				Person person = new Person(req.getParameter("firstname"), req.getParameter("lastname"),
						convertToSqlDate(req.getParameter("dob")), passport.getId());

				personRepository.create(person);

				resp.sendRedirect("/helloProjectWeb/persons");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (req.getParameter("edit") != null) {
			System.out.println("POST edit" + req.getParameter("id"));
			try {
				Passport passport = passportRepository
						.find(personRepository.find(Long.parseLong(req.getParameter("id"))).getPassportID());
				passport.setPassportNumber(req.getParameter("passportnumber"));
				passport.setValid_date(convertToSqlDate(req.getParameter("valid_date")));
				passportRepository.update(passport);

				Person person = personRepository.find(Long.parseLong(req.getParameter("id")));
				person.setFirstname(req.getParameter("firstname"));
				person.setLastname(req.getParameter("lastname"));
				person.setDob(convertToSqlDate(req.getParameter("dob")));
				person.setPassportID(passport.getId());
				personRepository.update(person);

				resp.sendRedirect("/helloProjectWeb/persons");

				// req.getRequestDispatcher("jsp/listPersons.jsp").forward(req,
				// resp);

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
