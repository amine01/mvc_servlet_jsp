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
		try {
			new PassportRepository().init();
			new PersonRepository().init();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/*
		 * try {
		 * 
		 * PassportRepository passportRepository = new PassportRepository();
		 * PersonRepository personRepository=new PersonRepository();
		 * 
		 * passportRepository.init(); personRepository.init();
		 * 
		 * SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		 * String dateInString = "05-05-2017 10:20:56"; Date date; java.sql.Date
		 * sqlDate; try { date = format.parse(dateInString); sqlDate=new
		 * java.sql.Date(date.getTime()); // java.sql.Date sqlDate = new
		 * java.sql.Date(new java.util.Date().getTime());
		 * 
		 * } catch (ParseException e) { // TODO Auto-generated catch block throw
		 * new RuntimeException(e); } Passport passport = new Passport("ab1521",
		 * sqlDate);
		 * 
		 * passportRepository.create(passport);
		 * 
		 * System.out.println(passport.getId()); Person person=new
		 * Person("amine","essadkaoui", sqlDate, passport.getId());
		 * personRepository.create(person);
		 * 
		 * 
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}
}
