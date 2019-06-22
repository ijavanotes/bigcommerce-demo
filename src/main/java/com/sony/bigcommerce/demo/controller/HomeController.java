package com.sony.bigcommerce.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home(Model model) throws JsonProcessingException
	{
		
		return "home";
	}
	
}
