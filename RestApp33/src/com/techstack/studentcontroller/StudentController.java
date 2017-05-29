package com.techstack.studentcontroller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController{
	
	// List all student records
	@ResponseBody
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public ArrayList<StudentModel> getStudentList(){
		StudentModel student1 = new StudentModel();
		student1.setStudentName("Amit");
		student1.setStudentAge(25);
		
		StudentModel student2 = new StudentModel();
		
		student2.setStudentName("Sumit");
		student2.setStudentAge(25);
		
		StudentModel student3 = new StudentModel();
		
		student3.setStudentName("Suneeta");
		student3.setStudentAge(25);
		
		ArrayList<StudentModel> students = new ArrayList<StudentModel>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		
		return students;
	}

	// get a student record
	@ResponseBody
	@RequestMapping(value="/students/{name}", method=RequestMethod.GET)
	public StudentModel getStudentDetails(@PathVariable("name") String studentName){
		StudentModel student1 = new StudentModel();
		student1.setStudentName(studentName);
		student1.setStudentAge(25);
		
		return student1;
	}
	
	
}
