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
import br.com.senai.cinema.models.Secao;
import br.com.senai.cinema.services.SecaoService;
import javassist.tools.rmi.ObjectNotFoundException;

//@RestController
@Controller
@RequestMapping(value="/secao")
public class SecaoResource {
	
	@Autowired
	private SecaoService secaoService;
	
	@GetMapping
	public String secoes(HttpServletRequest request) { 

		List<Secao> secoes = secaoService.findAll();

		request.setAttribute("secoes", secoes);
		return "secao";
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) throws NumberFormatException, ObjectNotFoundException {
		Secao secao = secaoService.findById(Integer.parseInt(id));
		if (secao != null) {
			secaoService.delete(secao);
		}
		return ResponseEntity.ok().body("excluido");
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateReturningJson(@PathVariable Integer id, @RequestBody Secao secao) throws ObjectNotFoundException {
		Secao objSecao = secaoService.findById(id);
		objSecao.setDataHora(secao.getDataHora());
		objSecao.setValorDoIngresso(secao.getValorDoIngresso());
		objSecao.setIdSala(secao.getIdSala());
		objSecao.setIdFilme(secao.getIdFilme());
		secaoService.update(objSecao);
		
		return ResponseEntity.ok().body("atualizado");
	}
	
	@GetMapping(value="/secao/ingressos/{id}")
	public String listAllIngressosBySecao(@PathVariable Integer idSecao, HttpServletRequest request) throws ObjectNotFoundException { 

		Secao secao = secaoService.findById(idSecao);
		
		List<Ingresso> ingressos = secaoService.listAllIngressosBySecao(secao);

		request.setAttribute("ingressos", ingressos);
		return "listagem-de-ingressos-por-secao";
	}

}
