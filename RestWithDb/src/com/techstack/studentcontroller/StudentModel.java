package com.techstack.studentcontroller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL) // ignore the null value from json
@JsonIgnoreProperties({"panNo"})
@JsonPropertyOrder({"studentAge", "studentName"}) // deside the property order into json
public class StudentModel {
	@JsonProperty("student_name")
	private String studentName;
	
	@JsonProperty("student_age")       // Change the field name to display in to client json 
	private int studentAge;

	private String panNo;
	private String address;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public StudentModel(String studentName, int studentAge, String panNo, String address){
		setStudentName(studentName);
		setStudentAge(studentAge);
		setPanNo(panNo);
		setAddress(address);
	}
	
}
