package br.com.senai.cinema.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.cinema.models.Usuario;
import br.com.senai.cinema.services.UsuarioService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/listagem")
	public List<Usuario> usuarios() {
		return  usuarioService.findAll();
	}
	
	@GetMapping("/listagem/{id}")
	public Usuario getUsuario(@PathVariable(value="id") Integer id) throws ObjectNotFoundException {
		return  usuarioService.findById(id);
	}
	
	@DeleteMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public void delete(@RequestBody Usuario usuario) {
		usuarioService.delete(usuario);
	}
	
	@PutMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public Usuario update(@RequestBody Usuario usuario) {
		return usuarioService.update(usuario);
	}

}
