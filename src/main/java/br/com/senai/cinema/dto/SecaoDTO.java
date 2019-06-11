package br.com.senai.cinema.dto;

public class SecaoDTO {
	
	private Integer id;
	
	private String data;
	
	private String hora;
	
	private float valorDoIngresso;
	
	private String numeroDaSala;
	
	private String nomeDoFilme;

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

	public String getNumeroDaSala() {
		return numeroDaSala;
	}

	public void setNumeroDaSala(String numeroDaSala) {
		this.numeroDaSala = numeroDaSala;
	}

	public String getNomeDoFilme() {
		return nomeDoFilme;
	}

	public void setNomeDoFilme(String nomeDoFilme) {
		this.nomeDoFilme = nomeDoFilme;
	}

	@Override
	public String toString() {
		return "SecaoDTO [id=" + id + ", data=" + data + ", hora=" + hora + ", valorDoIngresso=" + valorDoIngresso
				+ ", numeroDaSala=" + numeroDaSala + ", nomeDoFilme=" + nomeDoFilme + "]";
	}

}
