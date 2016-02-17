package com.essamine.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private long id;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private Date dob;
	@Column
	private long passportID;

	public Person() {

	}

	public Person(String firstname, String lastname, Date dob, long passportID) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.passportID = passportID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getPassportID() {
		return passportID;
	}

	public void setPassportID(long passportID) {
		this.passportID = passportID;
	}

}
