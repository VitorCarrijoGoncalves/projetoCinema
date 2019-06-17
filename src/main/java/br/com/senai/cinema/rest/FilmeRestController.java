package br.com.senai.cinema.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.cinema.dto.FilmeDTO;
import br.com.senai.cinema.models.Filme;
import br.com.senai.cinema.models.Usuario;
import br.com.senai.cinema.services.FilmeService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/filmes")
public class FilmeRestController {
	
	@Autowired
	private FilmeService filmeService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Filme> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Filme filme = filmeService.findById(id);
		return ResponseEntity.ok().body(filme);
	}
	
	@GetMapping
	public ResponseEntity<List<FilmeDTO>> findAllDTO() {
		List<FilmeDTO> filmesDto = filmeService.convertAllFilmesfromDTO();
		return ResponseEntity.ok().body(filmeService.getFilmesEmCartaz(filmesDto));
	}
	
	// Converter para dto
	
	@GetMapping(value="/indicados")
	public ResponseEntity<List<FilmeDTO>> getFilmesIndicados() throws ObjectNotFoundException {
		List<Filme> filmes = new ArrayList<Filme>();
		
		filmes.add(filmeService.findById(filmeService.getFilmeMaisVendido()));
		filmes.add(filmeService.findById(filmeService.getFilmeIdade(Usuario.usuarioLogado)));
		filmes.add(filmeService.findById(filmeService.getFilmeEstciv(Usuario.usuarioLogado)));
		filmes.add(filmeService.findById(filmeService.getFilmeSexo(Usuario.usuarioLogado)));
		
		List<FilmeDTO> filmesDto = filmeService.convertListFilmesFromDto(filmes);		
		
		return ResponseEntity.ok().body(filmeService.getFilmesEmCartaz(filmesDto));
		
	}
	
}
