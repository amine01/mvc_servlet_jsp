package com.essamine.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Child extends UrlEntity {

	@Column
	private String firstname;
	@OneToOne(cascade = CascadeType.ALL)
	Passport passport;

	@ManyToOne
	Married married;

	public Child() {
	}

	public Child(Passport passport) {
		this.passport = passport;
	}

	public Child(String firstname, Passport passport, Married married) {

		this.firstname = firstname;
		this.passport = passport;
		this.married = married;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Married getMarried() {
		return married;
	}

	public void setMarried(Married married) {
		this.married = married;
	}

}
