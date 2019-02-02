package br.com.senai.cinema.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.cinema.models.Ingresso;
import br.com.senai.cinema.services.IngressoService;

@RestController
@RequestMapping(value="/ingressos")
public class IngressoFormResource {

	@Autowired
	private IngressoService ingressoService;
	
	@PostMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public Ingresso save(@RequestBody Ingresso Ingresso) {
		return ingressoService.save(Ingresso);
	}
	
}
