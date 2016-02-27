package com.essamine.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Passport extends BaseEntity{
	
	@Column
	private String passportNumber;
	@Column
	private Date valid_date;

	public Passport() {
	}

	public Passport(String passportNumber, Date valid_date) {
		this.passportNumber = passportNumber;
		this.valid_date = valid_date;
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
