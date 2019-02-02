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

import br.com.senai.cinema.models.Filme;
import br.com.senai.cinema.services.FilmeService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/filme")
public class FilmeResource {
	
	@Autowired
	private FilmeService filmeService;
	
	@GetMapping("/listagem")
	public List<Filme> Filmes() {
		return  filmeService.findAll();
	}
	
	@GetMapping("/listagem/{id}")
	public Filme getFilme(@PathVariable(value="id") Integer id) throws ObjectNotFoundException {
		return  filmeService.findById(id);
	}
	
	@DeleteMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public void delete(@RequestBody Filme filme) {
		filmeService.delete(filme);
	}
	
	@PutMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public Filme update(@RequestBody Filme filme) {
		return filmeService.update(filme);
	}

}
