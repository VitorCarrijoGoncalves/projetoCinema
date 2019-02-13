package br.com.senai.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SiteController {
	
	@RequestMapping(value="/")
	public String login1() {
		return "redirect:/login";
	}
	
	@RequestMapping(value="/login")
	public String login2() {
		return "login";
	}

	@RequestMapping(value="/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/filme")
	public String filme() {
		return "filme";
	}
	
	@RequestMapping(value="/formulario-de-filme")
	public String formularioDeFilmes() {
		return "formulario-de-filme";
	}
	
	@RequestMapping(value="/ingresso")
	public String ingresso() {
		return "ingresso";
	}
	
	@RequestMapping(value="/formulario-de-ingresso")
	public String formularioDeIngressos() {
		return "formulario-de-ingresso";
	}
	
	@RequestMapping(value="/sala")
	public String sala() {
		return "sala";
	}
	
	@RequestMapping(value="/formulario-de-sala")
	public String formularioDeSalas() {
		return "formulario-de-sala";
	}
	
	@RequestMapping(value="/secao")
	public String secao() {
		return "secao";
	}
	
	@RequestMapping(value="/formulario-de-secao")
	public String formularioDeSecoes() {
		return "formulario-de-secao";
	}
	
	@RequestMapping(value="/usuario")
	public String usuario() {
		return "usuario";
	}
	
	@RequestMapping(value="/formulario-de-usuario")
	public String formularioDeUsuarios() {
		return "formulario-de-usuario";
	}
	
	@RequestMapping(value="/filme/secoes")
	public String listagemDeSecaoPorFilme() {
		return "listagem-de-secoes-por-filme";
	}
	
	@RequestMapping(value="/sala/secoes")
	public String listagemDeSecaoPorSala() {
		return "listagem-de-secoes-por-sala";
	}
	
	@RequestMapping(value="/secao/ingressos")
	public String listagemDeIngressosPorSecao() {
		return "listagem-de-ingressos-por-secao";
	}
	
}
