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
	
	private String tipo;
	
	@OneToMany(
			mappedBy = "idFilme",
			cascade = CascadeType.REMOVE, 
			orphanRemoval = true,
			targetEntity = Secao.class,
			fetch = FetchType.LAZY) 
	private List<Secao> secoes;
	
//	private String capaDoFilme;

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
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Secao> getSecoes() {
		return secoes;
	}

	public void setSecoes(List<Secao> secoes) {
		this.secoes = secoes;
	}
	
}
