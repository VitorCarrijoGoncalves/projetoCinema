package br.com.senai.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.cinema.models.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

	Filme findById(Integer id);
	
	void deleteById(Integer id);
	
//	Optional <Filme> findById(Integer id);
	
}
