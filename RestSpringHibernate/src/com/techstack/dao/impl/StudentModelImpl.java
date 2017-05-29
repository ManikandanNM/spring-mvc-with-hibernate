package com.techstack.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentModelImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public int getStudentCount()
	{
		String sql = "select count(*) from students";
		Query query = getSessionFactory().openSession().createQuery(sql);
		return (int) query.uniqueResult();

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}