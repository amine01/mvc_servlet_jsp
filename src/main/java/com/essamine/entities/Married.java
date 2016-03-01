package com.essamine.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Married extends Person {

	@OneToMany(mappedBy = "married", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Child> children;

	public Married() {
	}

	public Married(String firstname, String lastname, Date dob, List<Child> children) {
		super(firstname, lastname, dob);
		this.children = children;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}

}
