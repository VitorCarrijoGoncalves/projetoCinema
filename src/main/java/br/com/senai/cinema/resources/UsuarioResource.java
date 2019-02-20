package br.com.senai.cinema.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.senai.cinema.models.Ingresso;
import br.com.senai.cinema.models.Usuario;
import br.com.senai.cinema.services.UsuarioService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping(value="/usuario")
public class UsuarioResource {
		
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public String usuarios(HttpServletRequest request) { 

		List<Usuario> usuarios = usuarioService.findAll();

		request.setAttribute("usuarios", usuarios);
		return "usuario";
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Usuario usuario) throws ObjectNotFoundException {
		Usuario objUsuario = usuarioService.findById(id);
		objUsuario.setNome(usuario.getNome());
		objUsuario.setEmail(usuario.getEmail());
		objUsuario.setLogin(usuario.getLogin());
		objUsuario.setSenha(usuario.getSenha());
		usuarioService.update(objUsuario);
		
		return ResponseEntity.ok().body("atualizado");
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) throws NumberFormatException, ObjectNotFoundException {
		Usuario usuario = usuarioService.findById(Integer.parseInt(id));
		if (usuario != null) {
			usuarioService.delete(usuario);
		}
		return ResponseEntity.ok().body("excluido");
	}
	
	@GetMapping("/ingressos/{id}")
	public String listAllIngressosByUsuario(@PathVariable Integer idUsuario, HttpServletRequest request) throws ObjectNotFoundException {
		
		Usuario usuario = usuarioService.findById(idUsuario);

		List<Ingresso> ingressos = usuarioService.listAllIngressosByUsuario(usuario);

		request.setAttribute("ingressos", ingressos);
		return "listagem-de-ingressos-por-usuario";
	}
	
}
