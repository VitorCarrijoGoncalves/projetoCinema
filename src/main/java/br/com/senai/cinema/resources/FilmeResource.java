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

//@RestController
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

//	@GetMapping("/listagem")
//	public List<Filme> Filmes() {
//		return  filmeService.findAll();
//	}

	@GetMapping("/listagem/{id}")
	public Filme getFilme(@PathVariable(value = "id") Integer id) throws ObjectNotFoundException {
		return filmeService.findById(id);
	}

//	@DeleteMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
//	public void delete(@RequestBody Filme filme) {
//		filmeService.delete(filme);
//	}

//	@DeleteMapping(value = "/delete/{id}")
//	public String deleteCustomer(@PathVariable String id) {
//		filmeService.deleteById(Integer.parseInt(id));
//		return "OK!";
//	}
//	
// obj vem no corpo da requisição
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) throws NumberFormatException, ObjectNotFoundException {
		Filme filme = filmeService.findById(Integer.parseInt(id));
		if (filme != null) {
			filmeService.delete(filme);
		}
		return ResponseEntity.ok().body("excluido");
	}

	@PutMapping("/listagem") // @RequestBody = obj vem no corpo da requisição
	public Filme update(@RequestBody Filme filme) {
		return filmeService.update(filme);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateReturningJson(@PathVariable Integer id, @RequestBody Filme filme) throws ObjectNotFoundException {
		System.out.println(filme);
//		Integer idFilme = Integer.parseInt(request.getParameter("idFilme"));
//		Filme filme = filmeService.findById(idFilme);
//		request.setAttribute("Filme", filme);
//		
//		Gson gson = new Gson();
//		String json = gson.toJson(filme);
//		
		
		Filme objFilme = filmeService.findById(id);
		objFilme.setNome(filme.getNome());
		objFilme.setDuracao(filme.getDuracao());
		objFilme.setGenero(filme.getGenero());
		objFilme.setSinopse(filme.getSinopse());
		objFilme.setStatus(filme.isStatus());
		filmeService.update(objFilme);
		
		return ResponseEntity.ok().body("atualizado");
	}

	@GetMapping("/secoes")
	public String listarSecoesPorFilme(HttpServletRequest request) throws ObjectNotFoundException {
		System.out.println(request.getParameter("nome"));
		Integer idFilme = Integer.parseInt(request.getParameter("idFilme"));

		Filme filme = filmeService.findById(idFilme);

		List<Secao> secoes = filmeService.listAllSecoesByFilme(filme);

		request.setAttribute("secoes", secoes);
		return "listagem-de-secoes-por-filme";
	}

}
