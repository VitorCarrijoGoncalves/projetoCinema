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
	
	@RequestMapping(method=RequestMethod.GET, value="/filme")
	public String filme() {
		return "filme";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/formulario-de-filme")
	public String cadastroDeFilmes() {
		return "formulario-de-filme";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/ingresso")
	public String ingresso() {
		return "ingresso";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/formulario-de-ingresso")
	public String cadastroDeIngressos() {
		return "formulario-de-ingresso";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/sala")
	public String sala() {
		return "sala";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/formulario-de-sala")
	public String cadastroDeSalas() {
		return "formulario-de-sala";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/secao")
	public String secao() {
		return "secao";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/formulario-de-secao")
	public String cadastroDeSecoes() {
		return "formulario-de-secao";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/usuario")
	public String usuario() {
		return "usuario";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/formulario-de-usuario")
	public String cadastroDeUsuarios() {
		return "formulario-de-usuario";
	}
	
}
