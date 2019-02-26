package br.com.senai.cinema.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Filme {
	
	@Id
	@GeneratedValue(generator="filme_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="filme_seq", sequenceName="filme_seq", allocationSize=1, initialValue=1)
	private Integer id;
	
	private String nome;
	
	private String genero;
	
	private String sinopse;
	
	private String duracao;
	
	private boolean status;
	
	@Transient
	private MultipartFile capaDoFilme;
	
	@OneToMany(
			mappedBy = "idFilme",
			cascade = CascadeType.REMOVE, 
			orphanRemoval = true,
			targetEntity = Secao.class,
			fetch = FetchType.LAZY) 
	private List<Secao> secoes;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public MultipartFile getCapaDoFilme() {
		return capaDoFilme;
	}

	public void setCapaDoFilme(MultipartFile capaDoFilme) {
		this.capaDoFilme = capaDoFilme;
	}

	public List<Secao> getSecoes() {
		return secoes;
	}

	public void setSecoes(List<Secao> secoes) {
		this.secoes = secoes;
	}
	
}
