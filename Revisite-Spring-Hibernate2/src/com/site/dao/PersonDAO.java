package com.site.dao;

import java.util.List;

import com.site.model.Person;

public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
}