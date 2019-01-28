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
	private IngressoRepository IngressoRepository;
	
	public Ingresso save(Ingresso obj) {
		obj.setId(null); // o Objeto novo a ser inserido precisa o ter p id nulo
		return IngressoRepository.save(obj);
	}
	
	public Ingresso findById(Integer id) throws ObjectNotFoundException {
		Ingresso Ingresso = IngressoRepository.findById(id);
		if (Ingresso == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id = " + id + ", Tipo: " + Ingresso.class.getName());
		}
		return Ingresso;
	}
	
	public Ingresso update(Ingresso obj) {
		if (obj.getId() != null) {
			return IngressoRepository.save(obj); // id nulo, objeto inserido, id diferente de nulo, objeto a ser atualizado
		}
		return null;
	}
	
	public void delete(Integer id) {
		if (id != null) {
			IngressoRepository.deleteById(id);
		}
	}
	
	public List<Ingresso> findAll() {
		return IngressoRepository.findAll();
	}
	
//	public Page<Ingresso> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		return IngressoRepository.findAll(pageRequest);
//	} // método utilizado para fazer a paginação(exibição) das Ingressos, por página
	
}
