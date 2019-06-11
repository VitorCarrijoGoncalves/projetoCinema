package br.com.senai.cinema.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.cinema.dto.SecaoDTO;
import br.com.senai.cinema.models.Ingresso;
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
	
	public List<SecaoDTO> fromDTO() {
		
		List<SecaoDTO> secoesDto = new ArrayList<SecaoDTO>();
		
		for (Secao secao : secaoRepository.findAll()) {
			
			SecaoDTO secaoDto = new SecaoDTO();
			
			secaoDto.setId(secao.getId());
			secaoDto.setValorDoIngresso(secao.getValorDoIngresso());
			secaoDto.setData(secao.getData());
			secaoDto.setHora(secao.getHora());
			secaoDto.setNumeroDaSala(secao.getIdSala().getNumero());
			secaoDto.setNomeDoFilme(secao.getIdFilme().getNome());
			
			secoesDto.add(secaoDto);
			
		}
		
		return secoesDto;
		
	}
	
	public List<Ingresso> listAllIngressosBySecao(Secao secao) throws ObjectNotFoundException {
		return secao.getIngressos();
	}
	
	public String convertData(String data) {
		
		String ano = data.substring(0, 4);
		String mes = data.substring(5, 7);
		String dia = data.substring(8, 10);
		String novaData = dia + "/" + mes + "/" + ano;
		return novaData;
		
	}
	
}
