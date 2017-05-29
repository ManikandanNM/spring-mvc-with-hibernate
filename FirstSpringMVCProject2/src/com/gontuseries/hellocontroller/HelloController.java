package com.gontuseries.hellocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/mvc")  // add /mvc/welcome in the url
public class HelloController{

	@RequestMapping("/welcome")
	public ModelAndView helloWorld(){
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("msg", "My FIRST SPRING MVC PROJECT");
		return modelAndView;
	}
	
	@RequestMapping("/hello")
	public ModelAndView hiUser(){
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("msg", "Hello User");
		return modelAndView;
	}

}
