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
	private UsuarioRepository usuarioRepository;
	
	public Usuario save(Usuario obj) {
		obj.setId(null); // o Objeto novo a ser inserido precisa o ter p id nulo
		return usuarioRepository.save(obj);
	}
	
	public Usuario findById(Integer id) throws ObjectNotFoundException {
		Usuario Usuario = usuarioRepository.findById(id);
		if (Usuario == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id = " + id + ", Tipo: " + Usuario.class.getName());
		}
		return Usuario;
	}
	
	public Usuario update(Usuario obj) {
		if (obj.getId() != null) {
			return usuarioRepository.save(obj); // id nulo, objeto inserido, id diferente de nulo, objeto a ser atualizado
		}
		return null;
	}
	
	public void delete(Usuario usuario) {
		if (usuario != null) {
			usuarioRepository.delete(usuario);
		}
	}
	
	public void deleteById(Integer id) {
		if (id != null ) {
			usuarioRepository.deleteById(id);
		}
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
//	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		return usuarioRepository.findAll(pageRequest);
//	} // método utilizado para fazer a paginação(exibição) das Usuarios, por página
	
}
