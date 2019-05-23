package br.com.senai.cinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.cinema.dto.SecaoDTO;
import br.com.senai.cinema.models.Secao;
import br.com.senai.cinema.services.SecaoService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/secoes")
public class SecaoRestController {
	
	@Autowired
	private SecaoService secaoService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Secao> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Secao secao = secaoService.findById(id);
		return ResponseEntity.ok().body(secao);
	}
	
//	@GetMapping
//	public ResponseEntity<List<Secao>> findAll() {
//		List<Secao> secoes = secaoService.findAll();
//		return ResponseEntity.ok().body(secoes);
//	}
	
	@GetMapping
	public ResponseEntity<List<SecaoDTO>> findAllDTO() {
		List<SecaoDTO> secoesDto = secaoService.fromDTO();
		return ResponseEntity.ok().body(secoesDto);
	}

}
