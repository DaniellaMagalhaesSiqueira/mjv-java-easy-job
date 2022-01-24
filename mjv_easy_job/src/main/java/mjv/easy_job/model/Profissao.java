package mjv.easy_job.model;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Profissao {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idProfissao;
	
	@Column(length= 30)
	private String nomeProfissao;
	
	@Column(columnDefinition="numeric(8,2)")
	private Double salarioMinimo;
	
	@Column(columnDefinition="numeric(8,2)")
	private Double salarioMaximo;

	@Transient
	private String salarioMedio;
	
	public String getNomeProfissao() {
		return nomeProfissao;
	}

	public void setNomeProfissao(String nomeProfissao) {
		this.nomeProfissao = nomeProfissao;
	}

	public Double getSalarioMinimo() {
		return salarioMinimo;
	}

	public void setSalarioMinimo(Double salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}

	public Double getSalarioMaximo() {
		return salarioMaximo;
	}

	public void setSalarioMaximo(Double salarioMaximo) {
		this.salarioMaximo = salarioMaximo;
	}

	public Integer getIdProfissao() {
		return idProfissao;
	}

	public void setIdProfissao(Integer idProfissao) {
		this.idProfissao = idProfissao;
	}

	public String getSalarioMedio() {
		String result = "R$ " + new DecimalFormat("#,##0.00").format((this.salarioMaximo + this.salarioMinimo)/2);
		return result;
	}

	@Override
	public String toString() {
		return "Profissao [idProfissao=" + idProfissao + ", nomeProfissao=" + nomeProfissao + ", salarioMinimo="
				+ salarioMinimo + ", salarioMaximo=" + salarioMaximo + ", salarioMedio=" + salarioMedio + "]";
	}
	
	
	
	
}
