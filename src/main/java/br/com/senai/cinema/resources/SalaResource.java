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

import br.com.senai.cinema.models.Sala;
import br.com.senai.cinema.services.SalaService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/sala")
public class SalaResource {
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping("/listagem")
	public List<Sala> Salas() {
		return  salaService.findAll();
	}
	
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

}
