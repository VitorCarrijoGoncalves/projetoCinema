package br.com.senai.cinema.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
//	@RequestMapping(value = "/ilionnet/blog", method = RequestMethod.GET)
//	public String index(HttpServletRequest request) { // metodo para deixar a tabela do BD na tela do Ilionet
//
//		List<Blog> blogs = blogNegocio.getAllBlog();
//
//		request.setAttribute("blogs", blogs);
//		return "/ilionnet/modulos/admin/admin-blog";
//	}
	
//	@GetMapping("/listagem")
//	public List<Usuario> usuarios() {
//		return  usuarioService.findAll();
//	}
	
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
