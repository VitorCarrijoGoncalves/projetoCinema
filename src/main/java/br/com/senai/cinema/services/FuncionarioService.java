package br.com.senai.cinema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.cinema.models.Funcionario;
import br.com.senai.cinema.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public boolean validarLogin(String email, String senha) {
		
		if(existeFuncionario(email)) {
			Funcionario funcionario = findByEmail(email);
			if(funcionario.getSenha().equals(senha)) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	public Funcionario findByEmail(String email) {
		Funcionario funcionario = funcionarioRepository.findByEmail(email);
		if (funcionario == null) {
			return null;
		}
		return funcionario;
	}
	
	public boolean existeFuncionario(String email) {
		if(findByEmail(email) !=null ) {
			return true;
		}
		return false;
		
	}

}
