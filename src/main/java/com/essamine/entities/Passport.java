package com.essamine.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.essamine.validators.PassportNumber;

@Entity
public class Passport extends BaseEntity {

	// @NotEmpty
	@Column(nullable = false, length = 64)
	@PassportNumber
	private String passportnumber;

	@Column(nullable = false, length = 64)
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date valid_date;

	public Passport() {
	}

	public Passport(String passportnumber, Date valid_date) {
		this.passportnumber = passportnumber;
		this.valid_date = valid_date;
	}

	public Date getValid_date() {
		return valid_date;
	}

	public String getPassportnumber() {
		return passportnumber;
	}

	public void setPassportnumber(String passportnumber) {
		this.passportnumber = passportnumber;
	}

	public void setValid_date(Date valid_date) {
		this.valid_date = valid_date;
	}

}
