package com.techstack.dao.impl;

import java.util.List;

import com.techstack.model.Students;

public interface StudentDao {
	public void save(Students student);
	public void delete(Students student);
	public void update(Students student);
	public Students list(int id);
	public List<Students> listAll();
}
