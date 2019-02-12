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
	private SecaoRepository secaoRepository;
	
	public Secao save(Secao obj) {
		obj.setId(null); // o Objeto novo a ser inserido precisa o ter p id nulo
		return secaoRepository.save(obj);
	}
	
	public Secao findById(Integer id) throws ObjectNotFoundException {
		Secao Secao = secaoRepository.findById(id);
		if (Secao == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id = " + id + ", Tipo: " + Secao.class.getName());
		}
		return Secao;
	}
	
	public Secao update(Secao obj) {
		if (obj.getId() != null) {
			return secaoRepository.save(obj); // id nulo, objeto inserido, id diferente de nulo, objeto a ser atualizado
		}
		return null;
	}
	
	public void delete(Secao secao) {
		if (secao != null) {
			secaoRepository.delete(secao);
		}
	}
	
	public void deleteById(Integer id) {
		if (id != null ) {
			secaoRepository.deleteById(id);
		}
	}
	
	public List<Secao> findAll() {
		return secaoRepository.findAll();
	}
	
//	public Page<Secao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		return secaoRepository.findAll(pageRequest);
//	} // método utilizado para fazer a paginação(exibição) das Secaos, por página
	
}
