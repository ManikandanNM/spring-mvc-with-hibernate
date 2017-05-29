package com.techstack.studentcontroller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // remove @ResponseBody from every method
public class StudentController {

	// List all student records
	// @RequestMapping(value="/students", method=RequestMethod.GET,
	// produces=MediaType.APPLICATION_XML_VALUE) // Support only xml
	@RequestMapping(value = "/students", method = RequestMethod.GET) // Support
																		// both
																		// xml
																		// as
																		// well
																		// as
																		// rest
	public ArrayList<StudentModel> getStudentList() {
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
	@RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
	public StudentModel getStudentDetails(@PathVariable("name") String studentName) {
		StudentModel student1 = new StudentModel();
		student1.setStudentName(studentName);
		student1.setStudentAge(25);

		return student1;
	}

	/*
	 * // get a student record
	 * 
	 * @RequestMapping(value="/students/{name}", method=RequestMethod.PUT)
	 * //consume=MediaType.APPLICATION_XML_VALUE) // Support only xml public
	 * Boolean updateStudentDetails(@PathVariable("name") String
	 * studentName, @RequestBody StudentModel student){
	 * 
	 * System.out.println("Student Needs to be updated Name" + studentName);
	 * System.out.println("Student Needs to be updated Age" +
	 * student.getStudentAge());
	 * System.out.println("Student Needs to be updated Pan" +
	 * student.getPanNo());
	 * 
	 * return true; }
	 */

	/*
	 * // update a student record
	 * 
	 * @RequestMapping(value="/students/{name}", method=RequestMethod.PUT)
	 * public ResponseEntity<Boolean> updateStudentDetails(@PathVariable("name")
	 * String studentName, @RequestBody StudentModel student){
	 * 
	 * if(studentName.equalsIgnoreCase("amit")){ return new
	 * ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND); }
	 * System.out.println("Student Needs to be updated Name" + studentName);
	 * System.out.println("Student Needs to be updated Age" +
	 * student.getStudentAge());
	 * System.out.println("Student Needs to be updated Pan" +
	 * student.getPanNo());
	 * 
	 * return new ResponseEntity<Boolean>(true, HttpStatus.OK); }
	 */

	// update a student record
	@RequestMapping(value = "/students/{name}", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> updateStudentDetails(@PathVariable("name") String studentName,
			@RequestBody StudentModel student) {

		System.out.println("Student Needs to be updated Name" + studentName);
		System.out.println("Student Needs to be updated Age" + student.getStudentAge());
		System.out.println("Student Needs to be updated Pan" + student.getPanNo());

		HttpHeaders hdr = new HttpHeaders();
		hdr.add("key1", "value1");
		hdr.add("key2", "value2");
		return new ResponseEntity<Boolean>(true, hdr, HttpStatus.OK);
	}
}
