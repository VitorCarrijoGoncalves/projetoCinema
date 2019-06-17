package br.com.senai.cinema.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.cinema.dto.FilmeDTO;
import br.com.senai.cinema.models.Filme;
import br.com.senai.cinema.models.Secao;
import br.com.senai.cinema.models.Usuario;
import br.com.senai.cinema.repositories.FilmeRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;
	
	public Filme save(Filme obj) {
		obj.setId(null); // o Objeto novo a ser inserido precisa o ter p id nulo
		return filmeRepository.save(obj);
	}
	
	public Filme findById(Integer id) throws ObjectNotFoundException {
		Filme filme = filmeRepository.findById(id);
		if (filme == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id = " + id + ", Tipo: " + Filme.class.getName());
		}
		return filme;
	}
	
	public Filme update(Filme obj) {
		if (obj.getId() != null) {
			return filmeRepository.save(obj); // id nulo, objeto inserido, id diferente de nulo, objeto a ser atualizado
		}
		return null;
	}
	
	public void delete(Filme filme) {
		if (filme != null) {
			filmeRepository.delete(filme);
		}
	}
	
	public void deleteById(Integer id) {
		if (id != null ) {
			filmeRepository.deleteById(id);
		}
	}
	
	public List<Filme> findAll() {
		return filmeRepository.findAll();
	}
	
	public List<FilmeDTO> fromDTO() {
		
		List<FilmeDTO> filmesDto = new ArrayList<FilmeDTO>();
		
		for (Filme filme : filmeRepository.findAll()) {
			
			FilmeDTO filmeDto = new FilmeDTO();
			
			filmeDto.setId(filme.getId());
			filmeDto.setDuracao(filme.getDuracao());
			filmeDto.setGenero(filme.getGenero());
			filmeDto.setNome(filme.getNome());
			filmeDto.setSinopse(filme.getSinopse());
			filmeDto.setStatus(filme.isStatus());
			
			filmesDto.add(filmeDto);
			
		}
		
		return filmesDto;
		
	}
	
	public List<Secao> listAllSecoesByFilme(Filme filme) {
		return filme.getSecoes();
	}
	
	public List<FilmeDTO> getFilmesEmCartaz(List<FilmeDTO> filmesDto) {
		
		List<FilmeDTO> filmesEmCartaz = new ArrayList<FilmeDTO>();
		
		for (FilmeDTO filmeDto : filmesDto) {
			
			if (filmeDto.isStatus()) {
				
				filmesEmCartaz.add(filmeDto);
				
			}
			
		}
		
		return filmesEmCartaz;
		
	}
	
	public Integer getFilmeMaisVendido() {
		return Integer.parseInt(filmeRepository.findFilmeByTOP());
	}
	public Integer getFilmeSexo(Usuario user) {
		return Integer.parseInt(filmeRepository.findFilmeByTOPSexo(user.getSexo()));
	}
	public Integer getFilmeEstciv(Usuario user) {
		return Integer.parseInt(filmeRepository.findFilmeByTOPestciv(user.getEstadoCivil()));
	}
	public Integer getFilmeIdade(Usuario user) {
		String idmin = ""; 
		String idmax = "";
		int idade = 0;
		idade = Integer.parseInt(user.getIdade());
		
		if(idade >=0 && idade <=11) {
			idmin ="0";
			idmax = "11";
		}
		else if(idade >=12 && idade <=17) {
			idmin ="12";
			idmax = "17";
		}
		else if(idade >=18 && idade <=29) {
			idmin ="18";
			idmax = "29";
		}
		else if(idade >=30 && idade <=60) {
			idmin ="30";
			idmax = "59";
		}
		else {
			idmin = "60";
			idmax = "110";
		}
		
		return Integer.parseInt(filmeRepository.findFilmeByTOPidade(idmin, idmax));
	}
	
	
	
}
