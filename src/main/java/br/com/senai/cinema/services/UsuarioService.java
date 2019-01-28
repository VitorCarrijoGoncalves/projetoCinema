package br.com.senai.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.cinema.models.Usuario;
import br.com.senai.cinema.repositories.UsuarioRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	public Usuario save(Usuario obj) {
		obj.setId(null); // o Objeto novo a ser inserido precisa o ter p id nulo
		return UsuarioRepository.save(obj);
	}
	
	public Usuario findById(Integer id) throws ObjectNotFoundException {
		Usuario Usuario = UsuarioRepository.findById(id);
		if (Usuario == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id = " + id + ", Tipo: " + Usuario.class.getName());
		}
		return Usuario;
	}
	
	public Usuario update(Usuario obj) {
		if (obj.getId() != null) {
			return UsuarioRepository.save(obj); // id nulo, objeto inserido, id diferente de nulo, objeto a ser atualizado
		}
		return null;
	}
	
	public void delete(Integer id) {
		if (id != null) {
			UsuarioRepository.deleteById(id);
		}
	}
	
	public List<Usuario> findAll() {
		return UsuarioRepository.findAll();
	}
	
//	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		return UsuarioRepository.findAll(pageRequest);
//	} // método utilizado para fazer a paginação(exibição) das Usuarios, por página
	
}
