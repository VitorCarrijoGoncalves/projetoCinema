package br.com.senai.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.cinema.models.Ingresso;
import br.com.senai.cinema.repositories.IngressoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class IngressoService {

	@Autowired
	private IngressoRepository ingressoRepository;
	
	public Ingresso save(Ingresso obj) {
		obj.setId(null); // o Objeto novo a ser inserido precisa o ter p id nulo
		return ingressoRepository.save(obj);
	}
	
	public Ingresso findById(Integer id) throws ObjectNotFoundException {
		Ingresso Ingresso = ingressoRepository.findById(id);
		if (Ingresso == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id = " + id + ", Tipo: " + Ingresso.class.getName());
		}
		return Ingresso;
	}
	
	public Ingresso update(Ingresso obj) {
		if (obj.getId() != null) {
			return ingressoRepository.save(obj); // id nulo, objeto inserido, id diferente de nulo, objeto a ser atualizado
		}
		return null;
	}
	
	public void delete(Ingresso ingresso) {
		if (ingresso != null) {
			ingressoRepository.delete(ingresso);
		}
	}
	
	public void deleteById(Integer id) {
		if (id != null ) {
			ingressoRepository.deleteById(id);
		}
	}
	
	public List<Ingresso> findAll() {
		return ingressoRepository.findAll();
	}
	
//	public Page<Ingresso> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		return ingressoRepository.findAll(pageRequest);
//	} // método utilizado para fazer a paginação(exibição) das Ingressos, por página
	
}
