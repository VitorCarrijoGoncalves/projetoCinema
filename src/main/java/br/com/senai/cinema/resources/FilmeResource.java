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
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.cinema.models.Filme;
import br.com.senai.cinema.repositories.FilmeRepository;

@RestController
@RequestMapping(value="/filmes")
public class FilmeResource {
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	@GetMapping("/Filmes")
	public List<Filme> listFilmes(){
		return filmeRepository.findAll();
	}
	
	@GetMapping("/Filme/{id}")
	public Filme getFilme(@PathVariable(value="id") Integer id){
		return filmeRepository.findById(id);
	}
	
	@PostMapping("/Filme")
	public Filme salvar(@RequestBody @Valid Filme filme) {
		return filmeRepository.save(filme);
	}
	
	@DeleteMapping("/Filme")
	public void deletar(@RequestBody @Valid Filme filme) {
		filmeRepository.delete(filme);
	}
	
	@PutMapping("/Filme")
	public Filme atualizar(@RequestBody @Valid Filme filme) {
		return filmeRepository.save(filme);
	}

}
