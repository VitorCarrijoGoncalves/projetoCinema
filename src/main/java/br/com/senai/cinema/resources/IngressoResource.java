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

import br.com.senai.cinema.models.Ingresso;
import br.com.senai.cinema.services.IngressoService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/ingresso")
public class IngressoResource {
	
	@Autowired
	private IngressoService ingressoService;
	
	@GetMapping("/listagem")
	public List<Ingresso> Ingressos() {
		return  ingressoService.findAll();
	}
	
	@GetMapping("/listagem/{id}")
	public Ingresso getIngresso(@PathVariable(value="id") Integer id) throws ObjectNotFoundException {
		return  ingressoService.findById(id);
	}
	
	@DeleteMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public void delete(@RequestBody Ingresso Ingresso) {
		ingressoService.delete(Ingresso);
	}
	
	@PutMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public Ingresso update(@RequestBody Ingresso Ingresso) {
		return ingressoService.update(Ingresso);
	}

}
