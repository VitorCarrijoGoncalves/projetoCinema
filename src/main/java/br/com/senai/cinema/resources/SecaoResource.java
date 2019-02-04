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

import br.com.senai.cinema.models.Secao;
import br.com.senai.cinema.services.SecaoService;
import javassist.tools.rmi.ObjectNotFoundException;

//@RestController
@Controller
@RequestMapping(value="/secao")
public class SecaoResource {
	
	@Autowired
	private SecaoService secaoService;
	
	@GetMapping
	public String secoes(HttpServletRequest request) { 

		List<Secao> secoes = secaoService.findAll();

		request.setAttribute("secoes", secoes);
		return "secao";
	}
	
//	@GetMapping("/listagem")
//	public List<Secao> Secaos() {
//		return  secaoService.findAll();
//	}
	
	@GetMapping("/listagem/{id}")
	public Secao getSecao(@PathVariable(value="id") Integer id) throws ObjectNotFoundException {
		return  secaoService.findById(id);
	}
	
	@DeleteMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public void delete(@RequestBody Secao secao) {
		secaoService.delete(secao);
	}
	
	@PutMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public Secao update(@RequestBody Secao secao) {
		return secaoService.update(secao);
	}

}
