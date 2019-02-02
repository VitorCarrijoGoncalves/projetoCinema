package br.com.senai.cinema.resources;

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
	
	@PostMapping("/cadastro") // @RequestBody = obj vem no corpo da requisição
	public Usuario save(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}

}
