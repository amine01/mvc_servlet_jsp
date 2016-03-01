package com.essamine.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.essamine.validators.Friend;

@Entity
@Friend
public class Single extends Person {

	@OneToOne(cascade = CascadeType.ALL, optional = false)
	private Passport passport;

	@ManyToOne
	private Single singleFriend;

	@ManyToOne
	private Married marriedFriend;

	public Single() {
	}

	public Single(String firstname, String lastname, Date dob, Passport passport, Single singleFriend,
			Married marriedfriend) {
		super(firstname, lastname, dob);
		this.passport = passport;
		this.singleFriend = singleFriend;
		this.marriedFriend = marriedfriend;
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

	public Single getSingleFriend() {
		return singleFriend;
	}

	public void setSingleFriend(Single singleFriend) {
		this.singleFriend = singleFriend;
	}

	public Married getMarriedFriend() {
		return marriedFriend;
	}

	public void setMarriedFriend(Married marriedFriend) {
		this.marriedFriend = marriedFriend;
	}

}
