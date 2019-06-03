package br.com.senai.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.cinema.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findById(Integer id);
	
	Usuario findByEmail(String email);
	
	void deleteById(Integer id);
	
	
	
	
	
	
	
	
	
	
	
	// Fazer consulta aqui no BD, utilizando o Spring Data, ver na documentação do Spring Data
	// como fazer as consultas no BD, caso necessite de uma consulta mais específica colocar a
	// anotação @Query em cima dos métodos e inserir entre aspas duplas o código JPQL
	
	//@Query("SELECT * FROM usuario;")
//	Usuario findById(Integer id);
	
//	@Query("Sele")
//	List<Filme> findFilmeBySexo(); 
	
	
	
	
}
