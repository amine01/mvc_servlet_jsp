package com.essamine.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Single extends Person {

	@OneToOne(cascade = CascadeType.ALL, optional = false)
	private Passport passport;

	public Single() {
	}

	public Single(String firstname, String lastname, Date dob, Passport passport) {
		super(firstname, lastname, dob);
		this.passport = passport;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

}
