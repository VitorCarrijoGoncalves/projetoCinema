package br.com.senai.cinema.rest;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

import br.com.senai.cinema.dto.IngressoDTO;
import br.com.senai.cinema.models.Ingresso;
import br.com.senai.cinema.services.IngressoService;
import br.com.senai.cinema.util.ErrorResponse;

@RestController
@RequestMapping(value="/ingresso")
public class IngressoRestController {
	
	@Autowired
	private IngressoService ingressoService;
	
	@PostMapping(value = "/new",
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					 MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Ingresso> insereIngresso(@RequestBody IngressoDTO ingressoDTO) throws FileNotFoundException, DocumentException {
		
		boolean resultado = ingressoService.validarIngresso(ingressoDTO);
		String[] detalhes = {"detalhe 1","detalhe 2"};
		
		if(!resultado) {
			ErrorResponse error = new ErrorResponse("Não autorizado", Arrays.asList(detalhes));
	        return new ResponseEntity(error, HttpStatus.UNAUTHORIZED); 
		} else {
			Ingresso ingresso = ingressoService.convertIngresso(ingressoDTO);
			ingressoService.save(ingresso);
			
			ingressoService.gerarComprovanteDePagamento(ingresso);
			
			
			return ResponseEntity.ok().body(ingresso);
		}
		
	}

}
