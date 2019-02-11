package br.com.senai.cinema.resources;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

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
	
//	@PostMapping("/cadastro") // @RequestBody = obj vem no corpo da requisição
//	public Usuario save(@RequestBody Usuario usuario) {
//		return usuarioService.save(usuario);
//	}
	
	@PostMapping(value = "/novo-cadastro")
	public String save(HttpServletRequest request)
			throws ParseException, IllegalStateException, IOException {

		String login = request.getParameter("login");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario();
		
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuarioService.save(usuario);
		
		return "formulario-de-usuario";
	}

}
