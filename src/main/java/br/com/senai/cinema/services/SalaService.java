package br.com.senai.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.cinema.models.Sala;
import br.com.senai.cinema.repositories.SalaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class SalaService {

	@Autowired
	private SalaRepository salaRepository;
	
	public Sala save(Sala obj) {
		obj.setId(null); // o Objeto novo a ser inserido precisa o ter p id nulo
		return salaRepository.save(obj);
	}
	
	public Sala findById(Integer id) throws ObjectNotFoundException {
		Sala Sala = salaRepository.findById(id);
		if (Sala == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id = " + id + ", Tipo: " + Sala.class.getName());
		}
		return Sala;
	}
	
	public Sala update(Sala obj) {
		if (obj.getId() != null) {
			return salaRepository.save(obj); // id nulo, objeto inserido, id diferente de nulo, objeto a ser atualizado
		}
		return null;
	}
	
	public void delete(Sala sala) {
		if (sala != null) {
			salaRepository.delete(sala);
		}
	}
	
	public void deleteById(Integer id) {
		if (id != null ) {
			salaRepository.deleteById(id);
		}
	}
	
	public List<Sala> findAll() {
		return salaRepository.findAll();
	}
	
//	public Page<Sala> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		return salaRepository.findAll(pageRequest);
//	} // método utilizado para fazer a paginação(exibição) das Salas, por página
	
}
