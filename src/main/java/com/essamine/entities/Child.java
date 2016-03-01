package com.essamine.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Child extends UrlEntity {

	@Column(nullable = false, length = 64)
	@NotBlank
	private String firstname;
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@NotBlank
	Passport passport;
	
	@ManyToOne(optional = false)
	@NotBlank
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
