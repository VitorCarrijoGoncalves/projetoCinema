package br.com.senai.cinema.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.senai.cinema.models.Filme;
import br.com.senai.cinema.models.Secao;
import br.com.senai.cinema.services.FilmeService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping(value = "/filme")
public class FilmeResource {

	@Autowired
	private FilmeService filmeService;

	@GetMapping
	public String filmes(HttpServletRequest request) {

		List<Filme> filmes = filmeService.findAll();

		request.setAttribute("filmes", filmes);
		return "filme";
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) throws NumberFormatException, ObjectNotFoundException {
		Filme filme = filmeService.findById(Integer.parseInt(id));
		if (filme != null) {
			filmeService.delete(filme);
		}
		return ResponseEntity.ok().body("excluido");
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateReturningJson(@PathVariable Integer id, @RequestBody Filme filme) throws ObjectNotFoundException {
		Filme objFilme = filmeService.findById(id);
		objFilme.setNome(filme.getNome());
		objFilme.setDuracao(filme.getDuracao());
		objFilme.setGenero(filme.getGenero());
		objFilme.setSinopse(filme.getSinopse());
		objFilme.setStatus(filme.isStatus());
		filmeService.update(objFilme);
		
		return ResponseEntity.ok().body("atualizado");
	}

	@GetMapping("/secoes/{id}")
	public String listAllSecoesByFilme(@PathVariable Integer idFilme, HttpServletRequest request) throws ObjectNotFoundException {
		
		Filme filme = filmeService.findById(idFilme);

		List<Secao> secoes = filmeService.listAllSecoesByFilme(filme);

		request.setAttribute("secoes", secoes);
		return "listagem-de-secoes-por-filme";
	}
	
	@GetMapping("/get-sinopse/{id}")
	public String getSinopse(@PathVariable Integer idFilme, HttpServletRequest request) throws ObjectNotFoundException {
		
		Filme filme = filmeService.findById(idFilme);
		
		String sinopse = filme.getSinopse();

		request.setAttribute("sinopse", sinopse);	
		return "filme";
	}

}
