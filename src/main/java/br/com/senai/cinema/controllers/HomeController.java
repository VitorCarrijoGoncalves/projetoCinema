package br.com.senai.cinema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(method=RequestMethod.GET, value="/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/home2")
	public String home2() {
		return "home2";
	}
	
}
