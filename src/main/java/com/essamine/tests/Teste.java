package com.essamine.tests;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Teste {
	static DataSource ds;
	static Connection cnt;
	public static void main(String[] args) throws Exception{
		
		InitialContext initialCtx=new InitialContext();
		Context ctx=(Context) initialCtx.lookup("java:comp/env");
		ds=(DataSource) ctx.lookup("jdbc/personDB");
		cnt=ds.getConnection();
	}

}
