package com.techstack.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.techstack.model.Students;

public class StudentDaoImpl implements StudentDao{
	

	private SessionFactory sessionFactory;


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Students student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Students student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Students student) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Students> listAll() {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		List<Students> slist = session.createQuery("from Students").list();
		session.close();
		return slist;
	}

	@Override
	public Students list(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}