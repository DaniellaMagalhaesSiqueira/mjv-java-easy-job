package mjv.easy_job.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Cadastro {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=100, nullable= false)
	private String nome;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataNascimento;
	
	@Column(length=14)
	private String cpf;
	
	@Column(length=15)
	private String rg;
	
	private boolean estrangeiro;
	
	@Column(length=80)
	private String naturalidade;
	
	@Column(length=50)
	private String nacionalidade;
	
	@Enumerated(EnumType.STRING)
	@Column()
	private Sexo sexo;
	
	@Embedded
	private Endereco endereco;
	
	@Column(length=15)
	private String telefone;
	
	@Column(length=14)
	private String celular;
	
	@Enumerated(EnumType.STRING)
	private Escolaridade escolaridade;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "prof_id")
	private Profissao profissao;
	
//	@Column(precision=8, scale=2)
	
	private String email;
	
	private String caminhoImagem;
	
	@Transient
	private MultipartFile arquivo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
//	public void setDataNascimento(String dataNascimento) {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
//	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public boolean isEstrangeiro() {
		return estrangeiro;
	}

	public void setEstrangeiro(boolean estrangeiro) {
		this.estrangeiro = estrangeiro;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}


	public MultipartFile getArquivo() {
		return arquivo;
	}

	public void setArquivo(MultipartFile arquivo) {
		this.arquivo = arquivo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cadastro [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", rg="
				+ rg + ", estrangeiro=" + estrangeiro + ", naturalidade=" + naturalidade + ", nacionalidade="
				+ nacionalidade + ", sexo=" + sexo + ", endereco=" + endereco + ", telefone=" + telefone + ", celular="
				+ celular + ", escolaridade=" + escolaridade + ", profissao=" + profissao + ", email=" + email
				+ ", caminhoImagem=" + caminhoImagem + ", arquivo=" + arquivo + "]";
	}
	
	
}
