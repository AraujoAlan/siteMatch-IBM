package Model;

import java.util.Date;

public class Certificacao {
	private int idCertificado;
	private String tipoCertificacao;
	private Date horas;
	private String lugar;
	
	public int getIdCertificado() {
		return idCertificado;
	}
	
	public void setIdCertificado(int idCertificado) {
		this.idCertificado = idCertificado;
	}
	
	public String getTipoCertificacao() {
		return tipoCertificacao;
	}
	
	public void setTipoCertificacao(String tipoCertificacao) {
		this.tipoCertificacao = tipoCertificacao;
	}
	
	public Date getHoras() {
		return horas;
	}
	
	public void setHoras(Date horas) {
		this.horas = horas;
	}
	
	public String getLugar() {
		return lugar;
	}
	
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	public void validarTipoCertificado() {
		
	}

}
