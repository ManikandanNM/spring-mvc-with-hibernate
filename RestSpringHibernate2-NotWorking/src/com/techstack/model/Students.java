package com.techstack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL) // ignore the null value from json
//@JsonIgnoreProperties({"panNo"})
//@JsonPropertyOrder({"studentAge", "studentName"}) // deside the property order into json
@Entity
public class Students {
	
	@Id @GeneratedValue
	private int studentId;
	
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
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	

}
