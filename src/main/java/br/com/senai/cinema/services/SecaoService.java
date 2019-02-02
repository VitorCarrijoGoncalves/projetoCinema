package br.com.senai.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.cinema.models.Secao;
import br.com.senai.cinema.repositories.SecaoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class SecaoService {

	@Autowired
	private SecaoRepository SecaoRepository;
	
	public Secao save(Secao obj) {
		obj.setId(null); // o Objeto novo a ser inserido precisa o ter p id nulo
		return SecaoRepository.save(obj);
	}
	
	public Secao findById(Integer id) throws ObjectNotFoundException {
		Secao Secao = SecaoRepository.findById(id);
		if (Secao == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id = " + id + ", Tipo: " + Secao.class.getName());
		}
		return Secao;
	}
	
	public Secao update(Secao obj) {
		if (obj.getId() != null) {
			return SecaoRepository.save(obj); // id nulo, objeto inserido, id diferente de nulo, objeto a ser atualizado
		}
		return null;
	}
	
	public void delete(Secao secao) {
		if (secao != null) {
			SecaoRepository.delete(secao);
		}
	}
	
	public List<Secao> findAll() {
		return SecaoRepository.findAll();
	}
	
//	public Page<Secao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		return SecaoRepository.findAll(pageRequest);
//	} // método utilizado para fazer a paginação(exibição) das Secaos, por página
	
}
