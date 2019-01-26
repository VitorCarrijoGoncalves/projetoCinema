package br.com.senai.cinema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.senai.cinema.models.Filme;
import br.com.senai.cinema.repositories.FilmeRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;
	
	public Filme salvar(Filme obj) {
		obj.setId(null); // o Objeto novo a ser inserido precisa o ter p id nulo
		return filmeRepository.save(obj);
	}
	
//	public Filme find(Integer id) {
//		Optional<Filme> obj = filmeRepository.findById(id);
//		if (obj == null) {
//			throw new ObjectNotFoundException("Objeto não encontrado! Id = " + id + ", Tipo: " + Filme.class.getName());
//		}
//		return obj.orElse(null);
//	}
	
	public Filme update(Filme obj) {
//		Filme newObj = find(obj.getId());
		if (obj.getId() != null) {
			return filmeRepository.save(obj); // id nulo, objeto inserido, id diferente de nulo, objeto a ser atualizado
		}
		return null;
	}
	
	public void delete(Integer id) throws Exception {
		//find(id); // para verifcar se este id existe
//		try {
		if (id != null) {
			filmeRepository.deleteById(id);
		}
//		} catch (Exception e) {
//			throw new Exception("Não é possível excluir um Filme que possui produtos");
//		}
	}
	
	public List<Filme> findAll() {
		return filmeRepository.findAll();
	}
	
//	public Page<Filme> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		return filmeRepository.findAll(pageRequest);
//	} // método utilizado para fazer a paginação(exibição) das Filmes, por página
	
}
