package br.com.senai.cinema.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.cinema.models.Sala;
import br.com.senai.cinema.services.SalaService;

@RestController
@RequestMapping(value="/formulario-de-sala")
public class SalaFormResource {
	
	@Autowired
	private SalaService salaService;
	
	@PostMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public Sala save(@RequestBody Sala sala) {
		return salaService.save(sala);
	}

}
