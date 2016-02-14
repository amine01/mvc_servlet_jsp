package com.essamine.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.essamine.entities.Person;

public class PersonRepository {
	private final DataSource ds;

	public PersonRepository() {
		try {
			Context ctx = new InitialContext();
			try {
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/personDB");
			} finally {
				ctx.close();
			}

		} catch (NamingException e) {
			throw new RuntimeException(e);
		}

	}

	public void init() throws SQLException {
		Connection cnt = ds.getConnection();
		try {
			Statement stmt = cnt.createStatement();
			try {
				String sql = "create table person(id integer generated by default as identity primary key,"
						+ "firstname varchar(255),lastname varchar(255),dob date,passport_id integer,foreign key (passport_id) references passport)";
				stmt.execute(sql);
			} finally {
				stmt.close();
			}
		} finally {
			cnt.close();
		}
	}

	public Person find(long id) throws SQLException {
		Connection cnt = ds.getConnection();
		try {
			Statement stmt = cnt.createStatement();
			try {
				String sql = "select * from person where id=" + id;
				ResultSet rs = stmt.executeQuery(sql);
				try {
					if (!rs.next()) {
						return null;
					} else {
						return format(rs);// return a person
					}
				} finally {
					rs.close();
				}
			} finally {
				stmt.close();
			}
		} finally {
			cnt.close();
		}

	}

	public void create(Person person) throws SQLException {
		Connection cnt = ds.getConnection();

		try {
			Statement stmt = cnt.createStatement();
			try {
				String sql = "insert into person(firstname,lastname,dob,passport_id) values(" + person.getFirstname()
						+ "," + person.getLastname() + "," + person.getDob() + "," + person.getPassportID() + ")";
				stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = stmt.getGeneratedKeys();
				try {
					if (rs.next())
						person.setId(rs.getLong("id"));
				} finally {
					rs.close();
				}
			} finally {
				stmt.close();
			}
		} finally {
			cnt.close();
		}

	}

	public void update(Person person) throws SQLException {
		Connection cnt = ds.getConnection();
		try {
			Statement stmt = cnt.createStatement();
			try {
				String sql = "update person set firstname='" + person.getFirstname() + "'" + ",lastname='"
						+ person.getLastname() + "' ,dob=" + person.getDob() + ",passport_id=" + person.getPassportID()
						+ " where id=" + person.getId();
				stmt.executeUpdate(sql);
			} finally {
				stmt.close();
			}
		} finally {
			cnt.close();
		}
	}

	public Person format(ResultSet rs) throws SQLException {
		Person person = new Person();
		person.setId(rs.getLong("id"));
		person.setFirstname(rs.getString("firstname"));
		person.setLastname(rs.getString("lastname"));
		person.setDob((rs.getDate("dob")));
		person.setPassportID(rs.getLong("passport_id"));

		return person;
	}
}

// public class PersonRepository {
