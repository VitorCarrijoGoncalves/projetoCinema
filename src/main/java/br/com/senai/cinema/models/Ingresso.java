package br.com.senai.cinema.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Ingresso {
	
	@Id
	@GeneratedValue(generator="ingresso_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="ingresso_seq", sequenceName="ingresso_seq", allocationSize=1, initialValue=1)
	private Integer id;
	
	private float valorDoIngresso;
	
	@ManyToOne
	private Usuario idPessoa;
	
	@ManyToOne
	private Secao idSecao;
	
	//private String lugar; exemplo = 1a, 2b, 3c ...

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public float getValorDoIngresso() {
		return valorDoIngresso;
	}

	public void setValorDoIngresso(float valorDoIngresso) {
		this.valorDoIngresso = valorDoIngresso;
	}

	public Usuario getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Usuario idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Secao getIdSecao() {
		return idSecao;
	}

	public void setIdSecao(Secao idSecao) {
		this.idSecao = idSecao;
	}
	
}
