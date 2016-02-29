package com.essamine.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Child extends BaseEntity {

	@Column
	private String firstname;
	@OneToOne
	Passport passport;
	
	@ManyToOne
	Married married;

	public Child() {
	}

	public Child(Passport passport) {
		this.passport = passport;
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
