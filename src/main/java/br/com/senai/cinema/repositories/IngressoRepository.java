package br.com.senai.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.cinema.models.Ingresso;

@Repository
public interface IngressoRepository extends JpaRepository<Ingresso, Integer> {

	Ingresso findById(Integer id);
	
	void deleteById(Integer id);
	
}
