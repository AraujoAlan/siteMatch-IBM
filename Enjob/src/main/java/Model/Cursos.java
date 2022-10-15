package Model;

import java.util.Date;

public class Cursos {
	private int idCursos;
	private String cursos;
	private String situacaoEscolaridade;
	private Date dataInicio;
	private Date dataAberto;
	private Date dataFinalizacao;
	
	public int getIdCursos() {
		return idCursos;
	}
	
	public void setIdCursos(int idCursos) {
		this.idCursos = idCursos;
	}
	
	public String getCursos() {
		return cursos;
	}
	
	public void setCursos(String cursos) {
		this.cursos = cursos;
	}
	
	public String getSituacaoEscolaridade() {
		return situacaoEscolaridade;
	}
	
	public void setSituacaoEscolaridade(String situacaoEscolaridade) {
		this.situacaoEscolaridade = situacaoEscolaridade;
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
	
	public void validarCursos() {
		
	}
}
