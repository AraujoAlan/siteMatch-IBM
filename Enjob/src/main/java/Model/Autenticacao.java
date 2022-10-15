package Model;

import Model.Usuario;

public class Autenticacao {
	private int idAutenticacao;
	private String token;
	private Usuario usuario;
	
	public int getIdAutenticacao() {
		return idAutenticacao;
	}
	
	public void setIdAutenticacao(int idAutenticacao) {
		this.idAutenticacao = idAutenticacao;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void gerarToken() {
		
	}
	
}
