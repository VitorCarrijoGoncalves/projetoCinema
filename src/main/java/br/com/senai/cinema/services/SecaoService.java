package br.com.senai.cinema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.cinema.repositories.FilmeRepository;

@Service
public class SecaoService {

	@Autowired
	private FilmeRepository filmeRepository;
	
}
