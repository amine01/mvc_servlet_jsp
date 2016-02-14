package com.essamine.tests;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class setup implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0){
		// TODO Auto-generated method stub
		DataSource ds;
		Connection cnt;
		
		InitialContext initialCtx;
		try {
			initialCtx = new InitialContext();
			Context ctx=(Context) initialCtx.lookup("java:comp/env");
			ds=(DataSource) ctx.lookup("jdbc/personDB");
			cnt=ds.getConnection();
			System.out.println(cnt.isClosed());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
