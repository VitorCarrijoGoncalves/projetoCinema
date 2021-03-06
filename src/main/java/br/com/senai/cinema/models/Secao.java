package br.com.senai.cinema.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Secao {

	@Id
	@GeneratedValue(generator="secao_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="secao_seq", sequenceName="secao_seq", allocationSize=1, initialValue=1)
	private Integer id;
	
	private String data;
	
	private String hora;
	
	private float valorDoIngresso;
	
	@ManyToOne
	private Sala idSala;
	
	@ManyToOne
	private Filme idFilme;
	
	@OneToMany(
			mappedBy = "idSecao",
			cascade = CascadeType.REMOVE, 
			orphanRemoval = true,
			targetEntity = Ingresso.class,
			fetch = FetchType.LAZY) 
	private List<Ingresso> ingressos = new ArrayList<Ingresso>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public float getValorDoIngresso() {
		return valorDoIngresso;
	}

	public void setValorDoIngresso(float valorDoIngresso) {
		this.valorDoIngresso = valorDoIngresso;
	}

	public Sala getIdSala() {
		return idSala;
	}

	public void setIdSala(Sala idSala) {
		this.idSala = idSala;
	}

	public Filme getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Filme idFilme) {
		this.idFilme = idFilme;
	}

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Secao other = (Secao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
