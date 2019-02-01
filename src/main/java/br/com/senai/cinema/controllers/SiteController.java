package br.com.senai.cinema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SiteController {
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	public String login1() {
		return "redirect:/login";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/login")
	public String login2() {
		return "login";
	}

	@RequestMapping(method=RequestMethod.GET, value="/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/filmes")
	public String filmes() {
		return "filmes";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/cadastro-de-filmes")
	public String cadastroDeFilmes() {
		return "cadastro-de-filmes";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/ingressos")
	public String ingressos() {
		return "ingressos";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/cadastro-de-ingressos")
	public String cadastroDeIngressos() {
		return "cadastro-de-ingressos";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/salas")
	public String salas() {
		return "salas";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/cadastro-de-salas")
	public String cadastroDeSalas() {
		return "cadastro-de-salas";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/secoes")
	public String secoes() {
		return "secoes";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/cadastro-de-secoes")
	public String cadastroDeSecoes() {
		return "cadastro-de-secoes";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/usuarios")
	public String usuarios() {
		return "usuarios";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/cadastro-de-usuarios")
	public String cadastroDeUsuarios() {
		return "cadastro-de-usuarios";
	}
	
}
