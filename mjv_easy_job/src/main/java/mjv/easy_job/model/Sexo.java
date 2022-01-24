package mjv.easy_job.model;

public enum Sexo {

	M ("Masculino"),
	F ("Feminino"),
	NB("Não Binário");
	
	private String nome;
	private Sexo(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}
