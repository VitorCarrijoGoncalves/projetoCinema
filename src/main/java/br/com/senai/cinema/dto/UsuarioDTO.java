package br.com.senai.cinema.dto;

public class UsuarioDTO {
	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Integer id, String email, String senha) {
		this.id = id;
		this.email = email;
		this.senha = senha;
	}
	
	private Integer id;

	private String email;
	
	private String senha;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", email=" + email + ", senha=" + senha + "]";
	}
	
}
