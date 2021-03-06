package br.com.senai.cinema.resources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.senai.cinema.services.FuncionarioService;

@Controller
//@RequestMapping(value="/login")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping("/login")
	public String confereLogin(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
//		Object x = request.getParameter("g-recaptcha-response");
				
		if(!funcionarioService.validarLogin(email, senha)) {
			request.setAttribute("erro", "Erro");
			return "/login";
		} else {
			return "/home";
		}
		
		
		
	}
	
}
