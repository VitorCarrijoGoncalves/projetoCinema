//package br.com.senai.cinema.resources;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import br.com.senai.cinema.models.Filme;
//import br.com.senai.cinema.services.FilmeService;
//
//@Controller
//@RequestMapping(value = "/home")
//public class HomeResource {
//	
//	@Autowired
//	private FilmeService filmeService;
//	
//	@GetMapping
//	public String setFilmesEmCartaz(HttpServletRequest request) {
//		
//		List<Filme> filmes = filmeService.findAll();
//
//		request.setAttribute("filmes", filmes);
//		
//		return "filme";
//		
//	}
//
//}
