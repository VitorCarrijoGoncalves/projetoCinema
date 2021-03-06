package br.com.senai.cinema.resources;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.senai.cinema.models.Usuario;
import br.com.senai.cinema.services.UsuarioService;

//@RestController
@Controller
@RequestMapping(value="/formulario-de-usuario")
public class UsuarioFormResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value = "/novo-cadastro")
	public String save(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, IllegalStateException, IOException {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String sexo = request.getParameter("sexo");
		String idade = request.getParameter("idade");
		String estadoCivil = request.getParameter("estadoCivil");

		Usuario usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setSexo(sexo);
		usuario.setIdade(idade);
		usuario.setEstadoCivil(estadoCivil);
		usuarioService.save(usuario);
		response.sendRedirect("/formulario-de-usuario");
		return "formulario-de-usuario";
	}

}
