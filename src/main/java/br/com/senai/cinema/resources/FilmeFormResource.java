package br.com.senai.cinema.resources;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.senai.cinema.models.Filme;
import br.com.senai.cinema.services.FilmeService;

//@RestController
@Controller
@RequestMapping(value="/formulario-de-filme")
public class FilmeFormResource {
	
	@Autowired
	private FilmeService filmeService;
	
	@PostMapping(value = "/novo-cadastro")
	public String save(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, IllegalStateException, IOException {

		String nome = request.getParameter("nome");
		String genero = request.getParameter("genero");
		String sinopse = request.getParameter("sinopse");
		String duracao = request.getParameter("duracao");

		Filme filme = new Filme();
		
		filme.setNome(nome);
		filme.setGenero(genero);
		filme.setSinopse(sinopse);
		filme.setDuracao(duracao);
		filme.setStatus(true);
		filmeService.save(filme);
		response.sendRedirect("/formulario-de-filme");
		return "formulario-de-filme";
	}

}
