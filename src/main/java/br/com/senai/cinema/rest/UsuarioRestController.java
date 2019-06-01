package br.com.senai.cinema.rest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.cinema.dto.UsuarioDTO;
import br.com.senai.cinema.services.UsuarioService;
import br.com.senai.cinema.util.ErrorResponse;

@RestController
@RequestMapping("/users")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value = "/auth",
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					 MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UsuarioDTO> loginApp(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
		
		boolean resultado = usuarioService.validarUsuarioLogin(usuarioDTO);
		String[] detalhes = {"detalhe 1","detalhe 2"};
		
		if(!resultado) {
			ErrorResponse error = new ErrorResponse("Não autorizado", Arrays.asList(detalhes));
	        return new ResponseEntity(error, HttpStatus.UNAUTHORIZED); 
		}
		
		return ResponseEntity.ok().body(usuarioDTO);
		
	}

}
