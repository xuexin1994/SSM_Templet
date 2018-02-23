package com.xin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloSpringMVC {

	@RequestMapping("/hello")
	public ModelAndView findAllList(){
		System.out.println("Hello SpringMVC");
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "Hello SpringMVC");
		mv.setViewName("success");
		return mv;
	}
}
