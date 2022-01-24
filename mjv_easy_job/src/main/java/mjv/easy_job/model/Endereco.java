package mjv.easy_job.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Embeddable
public class Endereco {
	
	@Column(length= 100)
	private String logradouro;
	
	@Column(length=5)
	private String numero;
	
	@Column(length= 80)
	private String bairro;
	
	@Column(length= 80)
	private String municipio;
	
	@Enumerated(EnumType.STRING)
	private UnidadeFederativa uf;
	
	@Column(length= 11)
	private String cep;

	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public UnidadeFederativa getUf() {
		return uf;
	}
	public void setUf(UnidadeFederativa uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
		
}
