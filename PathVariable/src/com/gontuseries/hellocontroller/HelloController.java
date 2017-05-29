package com.gontuseries.hellocontroller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController{

	@RequestMapping("/welcome/{fname}/{lname}")
	public ModelAndView userInfo(@PathVariable Map<String, String> pathVars){
		String fname = pathVars.get("fname");
		String lname = pathVars.get("lname");
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("msg", "Welcome * " + fname + " " + lname + " *");
		return modelAndView;
	}

}
