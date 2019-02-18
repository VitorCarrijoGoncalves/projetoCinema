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
public class Sala {
	
	@Id
	@GeneratedValue(generator="sala_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="sala_seq", sequenceName="sala_seq", allocationSize=1, initialValue=1)
	private Integer id;
	
	private String numero;
	
	private long quantidadeDeLugares;
	
	@OneToMany(
			mappedBy = "idSala",
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public long getQuantidadeDeLugares() {
		return quantidadeDeLugares;
	}

	public void setQuantidadeDeLugares(long quantidadeDeLugares) {
		this.quantidadeDeLugares = quantidadeDeLugares;
	}

	public List<Secao> getSecoes() {
		return secoes;
	}

	public void setSecoes(List<Secao> secoes) {
		this.secoes = secoes;
	}
	
}
