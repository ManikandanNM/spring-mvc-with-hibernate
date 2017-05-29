package com.techstack.studentcontroller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController{

	@RequestMapping(value="/admissionForm.html", method=RequestMethod.GET)
	public ModelAndView studentAdmission(){
		return new ModelAndView("AdmissionForm");
	}
	
	@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmission(@RequestParam Map<String, String> reqParam){
	
		String name = reqParam.get("studentName");
		String age = reqParam.get("studentAge");
		
		ModelAndView model = new ModelAndView("SubmitAdmissionForm");
		model.addObject("msg", "Student Name: " + name + " Age: " + age);
		
		return model;
	}

}
