package com.techstack.studentcontroller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techstack.dao.impl.StudentDao;
import com.techstack.model.Students;

@RestController
public class StudentController {
	
	// get a student record
	@SuppressWarnings("resource")
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<Students> getStudentDetails() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/spring.xml");
		StudentDao simpl = ctx.getBean(StudentDao.class);
		return simpl.listAll();
		
	}
	
/*	// get a student record
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
	}*/

}
