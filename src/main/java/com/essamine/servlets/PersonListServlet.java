package com.essamine.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.essamine.repositories.PersonRepository;

@WebServlet("/persons")
public class PersonListServlet extends HttpServlet {
	private final PersonRepository personRepository = new PersonRepository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setAttribute("persons", personRepository.findAll());
			RequestDispatcher view = req.getRequestDispatcher("jsp/list_persons.jsp");
			view.forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
