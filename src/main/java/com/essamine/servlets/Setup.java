package com.essamine.servlets;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.essamine.entities.Passport;
import com.essamine.entities.Person;
import com.essamine.repositories.PassportRepository;
import com.essamine.repositories.PersonRepository;

// this listner will run your code before the web application is started.
@WebListener
public class Setup implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		PassportRepository passportRepository = new PassportRepository();
		PersonRepository personRepository = new PersonRepository();

		try {
			passportRepository.init();
			personRepository.init();
		} catch (SQLException e) {
			e.printStackTrace();
		}
/*
		try {

			//passportRepository.init();
			//personRepository.init();
			// ########################## fixing date problem
			SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			String dateInString = "05-05-2017 10:20:56";
			Date date;
			java.sql.Date sqlDate;

			try {
				date = format.parse(dateInString);
				sqlDate = new java.sql.Date(date.getTime());
			} catch (ParseException e) { // TODO Auto-generated catch block
											//
				throw new RuntimeException(e);
			}
			// ########################## end fixing date problem
			Passport passport = new Passport("ab1521", sqlDate);
			Passport passport2 = new Passport("a012", sqlDate);

			passportRepository.create(passport);
			passportRepository.create(passport2);

			// System.out.println(passport.getId());
			Person person = new Person("amine", "essadkaoui", sqlDate, passport.getId());
			Person person2 = new Person("salim", "selali", sqlDate, passport2.getId());
			personRepository.create(person);
			personRepository.create(person2);

		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	}
}
