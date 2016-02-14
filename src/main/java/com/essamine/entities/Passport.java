package com.essamine.entities;

import java.util.Date;

public class Passport {
	private long id;
	private String passportNumber;
	private Date valid_date;

	public Passport() {
	}

	public Passport(String passportNumber, Date valid_date) {
		this.passportNumber = passportNumber;
		this.valid_date = valid_date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Date getValid_date() {
		return valid_date;
	}

	public void setValid_date(Date valid_date) {
		this.valid_date = valid_date;
	}

}
