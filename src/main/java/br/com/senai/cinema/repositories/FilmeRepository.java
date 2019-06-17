package br.com.senai.cinema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import br.com.senai.cinema.models.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

	Filme findById(Integer id);
	
	void deleteById(Integer id);
	
	
	//funcionando 
		@Query(value="select idfilme from (SELECT ingresso.id, COUNT(ingresso.id)AS "
				+ "TOTALVENDIDO,SECAO.ID_FILME_ID AS IDFILME FROM SECAO INNER JOIN "
				+ "iNGRESSO ON iNGRESSO.ID_SECAO_ID = SECAO.ID INNER JOIN USUARIO ON "
				+ "iNGRESSO.ID_USUARIO_ID = USUARIO.ID GROUP BY SECAO.ID_FILME_ID ,ingresso.id ORDER BY ingresso.id, "
				+ "TOTALVENDIDO DESC LIMIT 1) as Result;", nativeQuery = true)
		String findFilmeByTOP();
		
		
	
}
