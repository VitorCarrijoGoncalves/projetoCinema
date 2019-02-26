package br.com.senai.cinema.resources;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.senai.cinema.models.Sala;
import br.com.senai.cinema.services.SalaService;

//@RestController
@Controller
@RequestMapping(value="/formulario-de-sala")
public class SalaFormResource {
	
	@Autowired
	private SalaService salaService;
	
	@PostMapping(value = "/novo-cadastro")
	public String save(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, IllegalStateException, IOException {

		String numero = request.getParameter("numero");
		String quantidadeDeLugares = request.getParameter("quantidadeDeLugares");

		Sala sala = new Sala();
		
		sala.setNumero(numero);
		sala.setQuantidadeDeLugares(Long.parseLong(quantidadeDeLugares));
		salaService.save(sala);
		response.sendRedirect("/formulario-de-filme");
		return "formulario-de-sala";
	}

}
