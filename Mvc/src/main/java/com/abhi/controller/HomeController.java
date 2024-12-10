package com.abhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	//www.chetu.com
	
	
	/*
	 * @GetMapping ->Get
	 * @PostMapping ->Post
	 * @PutMapping ->Put
	 * @DeletMapping->Delete
	 * 
	 * @RequestMapping(value="/",method=HttpMethod.Get)
	 * 
	 */
	
	
	/*
	 * 
	 * Model->interface -> home ->home.jsp
	 * ModelAndView->class ->
	 * 
	 * 
	 * 
	 */

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "Welcome to the Student Management System!");
		return "home";
	}
}
