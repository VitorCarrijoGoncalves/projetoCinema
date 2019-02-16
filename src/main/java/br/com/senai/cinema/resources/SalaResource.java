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

import br.com.senai.cinema.models.Sala;
import br.com.senai.cinema.models.Secao;
import br.com.senai.cinema.services.SalaService;
import javassist.tools.rmi.ObjectNotFoundException;

//@RestController
@Controller
@RequestMapping(value="/sala")
public class SalaResource {
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping("/sala")
	public String salas(HttpServletRequest request) { 

		List<Sala> salas = salaService.findAll();

		request.setAttribute("salas", salas);
		return "sala";
	}
	
//	@GetMapping("/listagem")
//	public List<Sala> Salas() {
//		return  salaService.findAll();
//	}
	
	@GetMapping("/listagem/{id}")
	public Sala getSala(@PathVariable(value="id") Integer id) throws ObjectNotFoundException {
		return  salaService.findById(id);
	}
	
	@DeleteMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public void delete(@RequestBody Sala sala) {
		salaService.delete(sala);
	}
	
	@PutMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public Sala update(@RequestBody Sala sala) {
		return salaService.update(sala);
	}
	
	@DeleteMapping("/delete-sala") // @RequestBody = obj vem no corpo da requisição
	public void deleteById(HttpServletRequest request) {
		String idSala = request.getParameter("idSala");
		salaService.deleteById(Integer.parseInt(idSala));
	}
	
	@GetMapping("/sala/secoes")
	public String listarSecoesPorSala(@PathVariable Integer idSala, HttpServletRequest request) throws ObjectNotFoundException { 

		Sala sala = salaService.findById(idSala);
		
		List<Secao> secoes = salaService.listAllSecoesBySala(sala);

		request.setAttribute("secoes", secoes);
		return "listagem-de-secoes-por-sala";
	}

}
