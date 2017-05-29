package com.journaldev.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.journaldev.dao.PersonDAO;
import com.journaldev.model.Person;

@Controller
public class SpringHibernateMain {
	
	@ResponseBody
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<Person> getStudentDetails() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		PersonDAO personDAO = context.getBean(PersonDAO.class);
		
		Person person = new Person();
		person.setName("Pankaj"); person.setCountry("India");
		
		personDAO.save(person);
		
		System.out.println("Person::"+person);
		
		List<Person> list = personDAO.list();
		//close resources
		context.close();	
		return list;
	}

	
}