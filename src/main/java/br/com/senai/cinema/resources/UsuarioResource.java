package br.com.senai.cinema.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.com.senai.cinema.models.Usuario;
import br.com.senai.cinema.services.UsuarioService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
//@RestController
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
	
//	@GetMapping("/listagem")
//	public List<Usuario> usuarios() {
//		return  usuarioService.findAll();
//	}
	
	@GetMapping("/listagem/{id}")
	public Usuario getUsuario(@PathVariable(value="id") Integer id) throws ObjectNotFoundException {
		return  usuarioService.findById(id);
	}
	
	@PutMapping("/update-usuario")
	public @ResponseBody String updateReturningJson(HttpServletRequest request, HttpServletResponse response) throws ObjectNotFoundException {

		Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		Usuario usuario = usuarioService.findById(idUsuario);
		request.setAttribute("usuario", usuario);
		
		Gson gson = new Gson();
		String json = gson.toJson(usuario);
		
		return json;
	}
	
	@PutMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public Usuario update(@RequestBody Usuario usuario) {
		return usuarioService.update(usuario);
	}
	
	@DeleteMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public void delete(@RequestBody Usuario usuario) {
		usuarioService.delete(usuario);
	}
	
	@DeleteMapping("/delete-usuario") // @RequestBody = obj vem no corpo da requisição
	public String deleteById(HttpServletRequest request) {
		String idUsuario = request.getParameter("idUsuario");
		System.out.println("Id Usuario" + idUsuario);
		usuarioService.deleteById(Integer.parseInt(idUsuario));
		return "usuario";
	}
	
}
