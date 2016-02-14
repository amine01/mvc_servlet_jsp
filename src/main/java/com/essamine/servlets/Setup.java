package com.essamine.servlets;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.essamine.repositories.PassportRepository;
import com.essamine.repositories.PersonRepository;

// this listner will run your code before the web application is started.
public class Setup implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		try {
			new PassportRepository().init();
			new PersonRepository().init();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
