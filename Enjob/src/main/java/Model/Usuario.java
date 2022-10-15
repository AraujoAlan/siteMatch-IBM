package Model;

import Model.Certificacao;
import Model.Contatos;
import Model.Cursos;
import Model.Endereco;
import Model.Experiencia;
import Model.Formacao;
import Model.Idiomas;
import Model.Login;
import Model.Email;

public class Usuario {
	private int id;
	private String nome;
	private String senha;
	private int idade;
	Contatos contatos;
	Endereco enderecos;
	Cursos curso;
	Idiomas idioma;
	Experiencia experiencia;
	Certificacao certificacao;
	Login login;
	Email email;
	
	public Email getEmail() {
		return email;
	}
	
	public Login getLogin() {
		return login;
	}
	
	public Certificacao getCertificacao() {
		return certificacao;
	}

	public void setCertificacao(Certificacao certificacao) {
		this.certificacao = certificacao;
	}

	public Experiencia getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}

	public Idiomas getIdioma() {
		return idioma;
	}

	public void setIdioma(Idiomas idioma) {
		this.idioma = idioma;
	}

	public Cursos getCurso() {
		return curso;
	}

	public void setCurso(Cursos curso) {
		this.curso = curso;
	}

	public Endereco getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco enderecos) {
		this.enderecos = enderecos;
	}

	public Formacao getFormacoes() {
		return formacoes;
	}

	public void setFormacoes(Formacao formacoes) {
		this.formacoes = formacoes;
	}

	Formacao formacoes;
	
	public Contatos getContatos() {
		return contatos;
	}

	public void setContatos(Contatos contatos) {
		this.contatos = contatos;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void Usuario() {
		
	}
	
	
	public void validarEmail() {
		
	}
	
	public void caracteresSenha() {
		
	}

	public void setEmail() {
		
	}

	public void setTelefone(int telefone) {
		
	}
	
}
