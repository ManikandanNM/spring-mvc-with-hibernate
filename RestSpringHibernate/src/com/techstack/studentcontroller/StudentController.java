package com.techstack.studentcontroller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techstack.model.Students;

@RestController
public class StudentController {

	// get a student record
	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public Students getStudentDetails(@PathVariable("id") int id) {
		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Students  st = (Students) session.get(Students.class, id);
		session.close();
		return st;
	}
	
	// get a student record
	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> removeStudentDetails(@PathVariable("id") int id) {
		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Students  st = (Students) session.load(Students.class, id);
		session.delete(st);
		session.close();
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	// create a new student record
	@RequestMapping(value="/students", method = RequestMethod.POST)
	public ResponseEntity<Boolean> createStudent(@RequestBody Students student) {
	
		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
		
		HttpHeaders hdr = new HttpHeaders();
		
		hdr.add("location",
				ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{name}")
				.buildAndExpand(student.getStudentName())
				.toUri()
				.toString());

		return new ResponseEntity<Boolean>(true, hdr, HttpStatus.CREATED);
	}
	
	// create a new student record
	@RequestMapping(value="/students", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> updateStudentDetails(@RequestBody Students student) {
	
		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(student);
		session.getTransaction().commit();
		session.close();
		
		HttpHeaders hdr = new HttpHeaders();
		
		hdr.add("location",
				ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{name}")
				.buildAndExpand(student.getStudentName())
				.toUri()
				.toString());

		return new ResponseEntity<Boolean>(true, hdr, HttpStatus.OK);
	}

}
