package br.com.senai.cinema.resources;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.cinema.models.Usuario;
import br.com.senai.cinema.services.UsuarioService;

@RestController
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

		// pega o atributo pelo name do html
		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario();
		
		usuario.setId(Integer.parseInt(id));
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		usuarioService.save(usuario);
		
		List<Usuario> usuarios = usuarioService.findAll();

		request.setAttribute("usuarios", usuarios);	

		return "formulario-de-usuario";
	}

}
