package br.com.senai.cinema.resources;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.senai.cinema.models.Filme;
import br.com.senai.cinema.models.Sala;
import br.com.senai.cinema.models.Secao;
import br.com.senai.cinema.services.FilmeService;
import br.com.senai.cinema.services.SalaService;
import br.com.senai.cinema.services.SecaoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping(value="/formulario-de-secao")
public class SecaoFormResource {
	
	@Autowired
	private SecaoService secaoService;
	
	@Autowired
	private FilmeService filmeService;
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping
	public String listarFilmesESalas(HttpServletRequest request, HttpServletResponse response) { 

		List<Filme> filmes = filmeService.findAll();
		List<Sala> salas = salaService.findAll();

		request.setAttribute("filmes", filmes);
		request.setAttribute("salas", salas);
		return "formulario-de-secao";
	}
	
	@PostMapping(value = "/novo-cadastro")
	public String save(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, IllegalStateException, IOException, NumberFormatException, ObjectNotFoundException {

		String idFilme = request.getParameter("idFilme");
		String idSala = request.getParameter("idSala");
		String data = request.getParameter("data");
		
		String hora = request.getParameter("hora");
		float valorDoIngresso = Float.parseFloat(request.getParameter("valorDoIngresso"));
		
		Filme filme = filmeService.findById(Integer.parseInt(idFilme));
		Sala sala = salaService.findById(Integer.parseInt(idSala));

		Secao secao = new Secao();
		
		secao.setIdFilme(filme);
		secao.setIdSala(sala);
		secao.setData(secaoService.convertData(data));
		secao.setHora(hora);
		secao.setValorDoIngresso(valorDoIngresso);
		secaoService.save(secao);
		response.sendRedirect("/formulario-de-secao");
		return "formulario-de-secao";
	}

}
