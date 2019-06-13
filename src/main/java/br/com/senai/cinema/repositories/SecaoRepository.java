package br.com.senai.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.cinema.models.Secao;

@Repository
public interface SecaoRepository extends JpaRepository<Secao, Integer> {

	Secao findById(Integer id);
	
	void deleteById(Integer id);
	
	
	
	
//	@Query(value="SELECT ingresso.id, COUNT(ingresso.id)AS "
//			+ "TOTALVENDIDO,SECAO.ID_FILME_ID AS IDFILME FROM SECAO INNER JOIN "
//			+ "iNGRESSO ON iNGRESSO.ID_SECAO_ID = SECAO.ID INNER JOIN USUARIO ON "
//			+ "iNGRESSO.ID_USUARIO_ID = USUARIO.ID GROUP BY SECAO.ID_FILME_ID ,ingresso.id ORDER BY ingresso.id, "
//			+ "TOTALVENDIDO DESC LIMIT 1;", nativeQuery = true)
//	List<Filme> findFilmeByTOP();
	
	
}

