package com.test.reactapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.reactapp.dao.JobSearchDAO;

@Controller
public class HomeController {
	
	@Autowired
	JobSearchDAO jobSearchDAO;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}

}
