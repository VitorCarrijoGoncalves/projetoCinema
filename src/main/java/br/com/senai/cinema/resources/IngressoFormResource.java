package br.com.senai.cinema.resources;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.senai.cinema.models.Ingresso;
import br.com.senai.cinema.models.Secao;
import br.com.senai.cinema.models.Usuario;
import br.com.senai.cinema.services.IngressoService;
import br.com.senai.cinema.services.SecaoService;
import br.com.senai.cinema.services.UsuarioService;
import javassist.tools.rmi.ObjectNotFoundException;

//@RestController
@Controller
@RequestMapping(value="/ingressos")
public class IngressoFormResource {

	@Autowired
	private IngressoService ingressoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private SecaoService secaoService;
	
	@GetMapping
	public String listarUsuariosESecoes(HttpServletRequest request, HttpServletResponse response) { 

		List<Usuario> usuarios = usuarioService.findAll();
		List<Secao> secoes = secaoService.findAll();
		
		request.setAttribute("usuarios", usuarios);
		request.setAttribute("secoes", secoes);
		return "formulario-de-ingresso";
	}
	
	@PostMapping(value = "/novo-cadastro")
	public String save(HttpServletRequest request)
			throws ParseException, IllegalStateException, IOException, NumberFormatException, ObjectNotFoundException {

		String idUsuario = request.getParameter("idUsuario");
		String idSecao = request.getParameter("idSecao");

		Ingresso ingresso = new Ingresso();
		
		Usuario usuario = usuarioService.findById(Integer.parseInt(idUsuario));
		Secao secao = secaoService.findById(Integer.parseInt(idSecao));
		
		ingresso.setIdUsuario(usuario);
		ingresso.setIdSecao(secao);
		ingressoService.save(ingresso);
		
		return "formulario-de-ingresso";
	}
	
}
