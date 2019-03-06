package br.com.senai.cinema.resources;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.senai.cinema.models.Filme;
import br.com.senai.cinema.services.FilmeService;

//@RestController
@Controller
@RequestMapping(value="/formulario-de-filme")
public class FilmeFormResource {
	
	@Autowired
	private FilmeService filmeService;
	
	@PostMapping(value = "/novo-cadastro")
	public String save(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile capa)
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
		
		
//		String uploadUrl = (UPLOAD_URL + gerarNome(false) + "/");
//		if (!(new File(uploadUrl).exists())) {
//
//			new File(uploadUrl).mkdir(); // criando um diretorio
//
//		}
//			
//		String fileName = gerarNome(true);
//		File file = new File(uploadUrl + fileName);
//		String fullStaticPath = BASE_PATH + gerarNome(false) + "/" + file.getName();
//		imagem.transferTo(file);
//
//		blog.setLinkDaImagem(fullStaticPath);
		
		
		filmeService.save(filme);
		response.sendRedirect("/formulario-de-filme");
		return "formulario-de-filme";
	}
	
	
	public String gerarNome(boolean isArquivo) {
		return isArquivo ? String.valueOf(new java.util.Date().getTime()) + ".jpg" : String.valueOf(new java.util.Date().getTime()) ;
	}
	

}
