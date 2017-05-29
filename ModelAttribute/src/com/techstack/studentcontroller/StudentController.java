package com.techstack.studentcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController{

	@RequestMapping(value="/admissionForm.html", method=RequestMethod.GET)
	public ModelAndView studentAdmission(){
		return new ModelAndView("AdmissionForm");
	}
	
/*	@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmission(@RequestParam Map<String, String> reqParam){
	
		StudentModel studentInfo = new StudentModel();
		
		studentInfo.setStudentName(reqParam.get("studentName"));
		studentInfo.setStudentAge(reqParam.get("studentAge"));
		
		ModelAndView model = new ModelAndView("SubmitAdmissionForm");
		model.addObject("msg", "****Congratulations your school will start soon...****");
		model.addObject("studentInfo", studentInfo);
		
		return model;
	}*/
	@ModelAttribute
	public void addCommonObject(Model model1){
		model1.addAttribute("HeaderMessage", "India's No. 1 Collage, Yogi's Collage..");
	}
	
	@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmission(@ModelAttribute("studentInfo") StudentModel studentInfo){

		ModelAndView model = new ModelAndView("SubmitAdmissionForm");
		model.addObject("msg", "****Congratulations your collage will start soon...****");
		
		return model;
	}

}
