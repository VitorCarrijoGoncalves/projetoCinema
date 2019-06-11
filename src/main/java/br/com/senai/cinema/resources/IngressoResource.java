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

import br.com.senai.cinema.models.Ingresso;
import br.com.senai.cinema.services.IngressoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping(value = "/ingresso")
public class IngressoResource {

	@Autowired
	private IngressoService ingressoService;
	
	@GetMapping
	public String ingressos(HttpServletRequest request) {

		List<Ingresso> ingressos = ingressoService.findAll();

		request.setAttribute("ingressos", ingressos);
		return "ingresso";
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) throws NumberFormatException, ObjectNotFoundException {
		Ingresso ingresso = ingressoService.findById(Integer.parseInt(id));
		if (ingresso != null) {
			ingressoService.delete(ingresso);
		}
		return ResponseEntity.ok().body("excluido");
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateReturningJson(@PathVariable Integer id, @RequestBody Ingresso ingresso) throws ObjectNotFoundException {
		Ingresso objIngresso = ingressoService.findById(id);
		objIngresso.setIdUsuario(ingresso.getIdUsuario());
		objIngresso.setIdSecao(ingresso.getIdSecao());
		ingressoService.update(objIngresso);
		
		return ResponseEntity.ok().body("atualizado");
	}

}
