package br.com.senai.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.cinema.models.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {

}
