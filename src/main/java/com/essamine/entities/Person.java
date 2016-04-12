package com.essamine.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person extends UrlEntity {

	@Column(nullable = false, length = 64)
	@NotBlank
	private String firstname;
	@Column(nullable = false, length = 64)
	@NotBlank
	private String lastname;

	@Column(nullable = false, length = 64)
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dob;

	// @Temporal(TemporalType.DATE)

	public Person() {

	}

	public Person(String firstname, String lastname, Date dob) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
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

	@Override
	public String toString() {
		return "Person [ID=" + super.getId() + "firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ "]";
	}

}
