package br.com.senai.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.cinema.models.Secao;

@Repository
public interface SecaoRepository extends JpaRepository<Secao, Integer> {

	Secao findById(Integer id);
	
	void deleteById(Integer id);
	
}

