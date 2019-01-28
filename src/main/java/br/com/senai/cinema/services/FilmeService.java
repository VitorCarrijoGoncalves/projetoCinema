package br.com.senai.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.cinema.models.Filme;
import br.com.senai.cinema.repositories.FilmeRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;
	
	public Filme save(Filme obj) {
		obj.setId(null); // o Objeto novo a ser inserido precisa o ter p id nulo
		return filmeRepository.save(obj);
	}
	
	public Filme findById(Integer id) throws ObjectNotFoundException {
		Filme filme = filmeRepository.findById(id);
		if (filme == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id = " + id + ", Tipo: " + Filme.class.getName());
		}
		return filme;
	}
	
	public Filme update(Filme obj) {
		if (obj.getId() != null) {
			return filmeRepository.save(obj); // id nulo, objeto inserido, id diferente de nulo, objeto a ser atualizado
		}
		return null;
	}
	
	public void delete(Integer id) {
		if (id != null) {
			filmeRepository.deleteById(id);
		}
	}
	
	public List<Filme> findAll() {
		return filmeRepository.findAll();
	}
	
//	public Page<Filme> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		return filmeRepository.findAll(pageRequest);
//	} // método utilizado para fazer a paginação(exibição) das Filmes, por página
	
}
