package br.com.senai.cinema.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.cinema.models.Filme;
import br.com.senai.cinema.services.FilmeService;

@RestController
@RequestMapping(value="/formulario-de-filme")
public class FilmeFormResource {
	
	@Autowired
	private FilmeService filmeService;
	@PostMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public Filme save(@RequestBody Filme filme) {
		return filmeService.save(filme);
	}

}
