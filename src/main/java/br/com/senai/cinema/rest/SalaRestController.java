package br.com.senai.cinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.cinema.models.Sala;
import br.com.senai.cinema.services.SalaService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/salas")
public class SalaRestController {
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Sala> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Sala sala = salaService.findById(id);
		return ResponseEntity.ok().body(sala);
	}
	
	@GetMapping
	public ResponseEntity<List<Sala>> findAll() {
		List<Sala> salas = salaService.findAll();
		return ResponseEntity.ok().body(salas);
	}

}
