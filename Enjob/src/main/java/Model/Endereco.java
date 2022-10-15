package Model;

public class Endereco {
	private String idEndereco;
	private String enderecos;
	private String estado;
	private String municipio;
	private String bairro;
	private String logradouro;
	private int cep;
	private int numero;
	private String complemento;
	private String pontoReferencia;
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	
	public String getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(String enderecos) {
		this.enderecos = enderecos;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	
	public String getIdEndereco() {
		return idEndereco;
	}
	
	public void setIdEndereco(String idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	public String getEndereco() {
		return enderecos;
	}
	
	public void setEndereco(String enderecos) {
		this.enderecos = enderecos;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public int getCep() {
		return cep;
	}
	
	public void setCep(int cep) {
		this.cep = cep;
	}
	
	public void exibirEnderecoBairro() {
		
	}

}
