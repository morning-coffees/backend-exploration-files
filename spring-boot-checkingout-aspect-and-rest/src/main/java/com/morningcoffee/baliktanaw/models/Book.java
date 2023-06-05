package com.morningcoffee.baliktanaw.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue
	public Long id;
	
	@Column(name="name")
	public String name;
	
	public Book() {
		
	}

	public Book(String name) {
		this.name = name;
	}
}
