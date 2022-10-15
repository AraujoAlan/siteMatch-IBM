package Model;

import java.util.Date;

public class Experiencia {
	private int idExperiencia;
	private String temExperiencia;
	private String comentariosExperiencia;
	private String nomeEmpresa;
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	private Date periodoInicio;
	private Date periodoAberto;
	private Date periodoFim;
	
	public int getIdExperiencia() {
		return idExperiencia;
	}
	
	public void setIdExperiencia(int idExperiencia) {
		this.idExperiencia = idExperiencia;
	}
	
	public String getTemExperiencia() {
		return temExperiencia;
	}
	
	public void setTemExperiencia(String temExperiencia) {
		this.temExperiencia = temExperiencia;
	}
	
	public String getComentariosExperiencia() {
		return comentariosExperiencia;
	}
	
	public void setComentariosExperiencia(String comentariosExperiencia) {
		this.comentariosExperiencia = comentariosExperiencia;
	}
	
	public Date getPeriodoInicio() {
		return periodoInicio;
	}
	
	public void setPeriodoInicio(Date periodoInicio) {
		this.periodoInicio = periodoInicio;
	}
	
	public Date getPeriodoAberto() {
		return periodoAberto;
	}
	
	public void setPeriodoAberto(Date periodoAberto) {
		this.periodoAberto = periodoAberto;
	}
	
	public Date getPeriodoFim() {
		return periodoFim;
	}
	
	public void setPeriodoFim(Date periodoFim) {
		this.periodoFim = periodoFim;
	}
	
	public void exibirComentarios() {
		
	}

}
