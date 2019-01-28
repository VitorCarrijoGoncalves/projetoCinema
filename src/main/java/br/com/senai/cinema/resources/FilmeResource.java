package br.com.senai.cinema.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.cinema.models.Filme;
import br.com.senai.cinema.services.FilmeService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/filmes")
public class FilmeResource {
	
	@Autowired
	private FilmeService filmeService;
	
	@GetMapping("/filmes")
	public List<Filme> listFilmes(){
		return filmeService.findAll();
	}
	
//	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@GetMapping(value="/{id}")
	public Filme findById(@PathVariable(value="id") Integer id) throws ObjectNotFoundException{
		return filmeService.findById(id);
	}
	
	@PostMapping("/filmes")
	public Filme save(@RequestBody @Valid Filme filme) {
		return filmeService.save(filme);
	}
	
	@DeleteMapping("/filmes")
	public void delete(@RequestBody @Valid Integer id) {
		filmeService.delete(id);
	}
	
	@PutMapping("/filmes")
	public Filme update(@RequestBody @Valid Filme filme) {
		return filmeService.save(filme);
	}

}
