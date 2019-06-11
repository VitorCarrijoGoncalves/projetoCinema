package br.com.senai.cinema.dto;

public class IngressoDTO {
	
	private Integer idUsuario;
	
	private Integer idSecao;
	
	private String tipoIngresso;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdSecao() {
		return idSecao;
	}

	public void setIdSecao(Integer idSecao) {
		this.idSecao = idSecao;
	}

	public String getTipoIngresso() {
		return tipoIngresso;
	}

	public void setTipoIngresso(String tipoIngresso) {
		this.tipoIngresso = tipoIngresso;
	}

	@Override
	public String toString() {
		return "IngressoDTO [idUsuario=" + idUsuario + ", idSecao=" + idSecao + ", tipoIngresso=" + tipoIngresso + "]";
	}
	
}
