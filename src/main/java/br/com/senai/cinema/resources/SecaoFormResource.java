package br.com.senai.cinema.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.cinema.models.Secao;
import br.com.senai.cinema.services.SecaoService;

@RestController
@RequestMapping(value="/formulario-de-secao")
public class SecaoFormResource {
	
	@Autowired
	private SecaoService SecaoService;
	
	@PostMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public Secao save(@RequestBody Secao secao) {
		return SecaoService.save(secao);
	}

}
