package br.com.senai.cinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.cinema.models.Secao;
import br.com.senai.cinema.services.SecaoService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/sessoes")
public class SecaoRestController {
	
	@Autowired
	private SecaoService sessaoService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Secao> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Secao sessao = sessaoService.findById(id);
		return ResponseEntity.ok().body(sessao);
	}
	
	@GetMapping
	public ResponseEntity<List<Secao>> findAll() {
		List<Secao> sessoes = sessaoService.findAll();
		return ResponseEntity.ok().body(sessoes);
	}

}
