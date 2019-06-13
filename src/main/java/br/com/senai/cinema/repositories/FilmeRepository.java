package br.com.senai.cinema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senai.cinema.models.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

	Filme findById(Integer id);
	
	void deleteById(Integer id);
	
	
	
	
	
	
	
	
	@Query(value="SELECT ingresso.id, COUNT(ingresso.id)AS "
			+ "TOTALVENDIDO,SECAO.ID_FILME_ID AS IDFILME FROM SECAO INNER JOIN "
			+ "iNGRESSO ON iNGRESSO.ID_SECAO_ID = SECAO.ID INNER JOIN USUARIO ON "
			+ "iNGRESSO.ID_USUARIO_ID = USUARIO.ID GROUP BY SECAO.ID_FILME_ID ,ingresso.id ORDER BY ingresso.id, "
			+ "TOTALVENDIDO DESC LIMIT 1;", nativeQuery = true)
	List<Filme> findFilmeByTOP();
	
	
	
	
	
	

//	@Query(value="SELECT COUNT(ingresso.id)AS TOTALVENDIDO, \r\n" + 	
//			"				SECAO.ID_FILME_ID AS IDFILME  \r\n" + 
//			"				FROM SECAO  \r\n" + 
//			"				INNER JOIN iNGRESSO ON iNGRESSO.ID_SECAO_ID = SECAO.ID  \r\n" + 
//			"				INNER JOIN USUARIO  ON iNGRESSO.ID_USUARIO_ID = USUARIO.ID  \r\n" + 
//			"				WHERE USUARIO.SEXO = '%usuarioLogado.(getSexo)%' GROUP BY SECAO.ID_FILME_ID\r\n" + 
//			"				ORDER BY TOTALVENDIDO DESC LIMIT 4;", nativeQuery = true)
//	List<Filme> findFilmeByTOPSexo(Usuario usuarioLogado);
//
//	@Query(value="SELECT COUNT(ingresso.id)AS TOTALVENDIDO, \r\n" + 
//			"				SECAO.ID_FILME_ID AS IDFILME  \r\n" + 
//			"				FROM SECAO  \r\n" + 
//			"				INNER JOIN iNGRESSO ON iNGRESSO.ID_SECAO_ID = SECAO.ID  \r\n" + 
//			"				INNER JOIN USUARIO  ON iNGRESSO.ID_USUARIO_ID = USUARIO.ID  \r\n" + 
//			"				WHERE USUARIO.estado_civil = '%estciv%' GROUP BY SECAO.ID_FILME_ID\r\n" + 
//			"				ORDER BY TOTALVENDIDO DESC LIMIT 4;", nativeQuery = true)
//	List<Filme> findFilmeByTOPestciv(String estciv);
//
//	@Query(value="SELECT COUNT(ingresso.id)AS TOTALVENDIDO, \r\n" + 
//			"				SECAO.ID_FILME_ID AS IDFILME  \r\n" + 
//			"				FROM SECAO  \r\n" + 
//			"				INNER JOIN iNGRESSO ON iNGRESSO.ID_SECAO_ID = SECAO.ID  \r\n" + 
//			"				INNER JOIN USUARIO  ON iNGRESSO.ID_USUARIO_ID = USUARIO.ID  \r\n" + 
//			"				WHERE USUARIO.IDADE between '%idmin%' and '%idmax%' GROUP BY SECAO.ID_FILME_ID\r\n" + 
//			"				ORDER BY TOTALVENDIDO DESC LIMIT 4;")
//	List<Filme> findFilmeByTOPidade(String idmin, String idmax);
	
}
