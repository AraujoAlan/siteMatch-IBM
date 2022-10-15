package Model;

public class Email {
	private int idEmail;
	private String senha;
	private String RecuperacaoSenha;
	
	public int getIdEmail() {
		return idEmail;
	}
	
	public void setIdEmail(int idEmail) {
		this.idEmail = idEmail;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getRecuperacaoSenha() {
		return RecuperacaoSenha;
	}
	
	public void setRecuperacaoSenha(String recuperacaoSenha) {
		RecuperacaoSenha = recuperacaoSenha;
	}
	
}
