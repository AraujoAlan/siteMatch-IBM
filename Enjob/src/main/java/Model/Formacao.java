package Model;

import java.util.Date;

public class Formacao {
	private int idFormacao;
	private String formacao;
	private String situacaoEscolaridade;
	private String escola;
	private String formacaoAcademica;
	private Date dataInicio;
	private Date dataAberto;
	private Date dataFinalizacao;
	
	public int getIdFormacao() {
		return idFormacao;
	}
	
	public void setIdFormacao(int idFormacao) {
		this.idFormacao = idFormacao;
	}
	
	public String getFormacao() {
		return formacao;
	}
	
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	public String getSituacaoEscolaridade() {
		return situacaoEscolaridade;
	}
	
	public void setSituacaoEscolaridade(String situacaoEscolaridade) {
		this.situacaoEscolaridade = situacaoEscolaridade;
	}
	
	public String getEscola() {
		return escola;
	}
	
	public void setEscola(String escola) {
		this.escola = escola;
	}
	
	public String getFormacaoAcademica() {
		return formacaoAcademica;
	}
	
	public void setFormacaoAcademica(String formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getDataAberto() {
		return dataAberto;
	}
	
	public void setDataAberto(Date dataAberto) {
		this.dataAberto = dataAberto;
	}
	
	public Date getDataFinalizacao() {
		return dataFinalizacao;
	}
	
	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	public void validarEscolaridade() {
		
	}
	
}
