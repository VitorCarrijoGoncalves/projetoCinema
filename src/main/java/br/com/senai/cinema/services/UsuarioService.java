package br.com.senai.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.cinema.dto.UsuarioDTO;
import br.com.senai.cinema.models.Ingresso;
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
	
	public Usuario findByEmail(String email) throws ObjectNotFoundException {
		
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		if (usuario == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Email = " + email + ", Tipo: " + Usuario.class.getName());
		}
		
		return usuario;
		
	}
	
	public boolean existeUsuarioCadastrado(String email) {
		
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		if (usuario != null) {
			return true;
		} else {
			return false;
		}
		
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
	
	public List<Ingresso> listAllIngressosByUsuario(Usuario usuario) {
		return usuario.getIngressos();
	}
	
	public Usuario fromUsuario(UsuarioDTO usuarioDTO) throws ObjectNotFoundException {
		
		Usuario usuario = findByEmail(usuarioDTO.getEmail());
		
		return usuario;
		
	}
	
	public boolean validarUsuarioLogin(UsuarioDTO usuarioDto) throws ObjectNotFoundException {
		
		// Fazer validação para que não possa cadastrar mais de um usuário com o mesmo email
		
		Usuario usuario = findByEmail(usuarioDto.getEmail());
		
		if (usuario != null) {
			
			if (usuarioDto.getSenha().equals(usuario.getSenha())) {
				usuarioDto.setId(usuario.getId());
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
		
	}

	public boolean validarCadastroDeUsuario(Usuario usuario) {
		
		boolean resultado = existeUsuarioCadastrado(usuario.getEmail());
		
		if (!resultado) {
			return true;
		} else {
			return false;
		}
		
	}
	
//	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		return usuarioRepository.findAll(pageRequest);
//	} // método utilizado para fazer a paginação(exibição) das Usuarios, por página
	
}
