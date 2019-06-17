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

import br.com.senai.cinema.models.Sala;
import br.com.senai.cinema.services.SalaService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping(value="/sala")
public class SalaResource {
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping
	public String salas(HttpServletRequest request) { 

		List<Sala> salas = salaService.findAll();

		request.setAttribute("salas", salas);
		return "sala";
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Sala> findById(@PathVariable Integer id, HttpServletRequest request) throws ObjectNotFoundException { 

		Sala sala = salaService.findById(id);

		return ResponseEntity.ok().body(sala);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id) throws NumberFormatException, ObjectNotFoundException {
		Sala sala = salaService.findById(Integer.parseInt(id));
		if (sala != null) {
			salaService.delete(sala);
		}
		return ResponseEntity.ok().body("excluido");
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateReturningJson(@PathVariable Integer id, @RequestBody Sala sala) throws ObjectNotFoundException {
		Sala objSala = salaService.findById(id);
		objSala.setNumero(sala.getNumero());
		objSala.setQuantidadeDeLugares(sala.getQuantidadeDeLugares());
		salaService.update(objSala);
		
		return ResponseEntity.ok().body("atualizado");
	}
	
//	@GetMapping("/secoes/{id}")
//	public String listAllSecoesBySala(@PathVariable Integer idSala, HttpServletRequest request) throws ObjectNotFoundException { 
//
//		Sala sala = salaService.findById(idSala);
//		
//		List<Secao> secoes = salaService.listAllSecoesBySala(sala);
//
//		request.setAttribute("secoes", secoes);
//		return "listagem-de-secoes-por-sala";
//	}

}
