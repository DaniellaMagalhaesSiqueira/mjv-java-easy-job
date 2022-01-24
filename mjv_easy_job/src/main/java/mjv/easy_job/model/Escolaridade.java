package mjv.easy_job.model;


public enum Escolaridade {
	A ("Analfabeto"),
	LE("Lê e Escreve"),
	FUND_INC("Fundamental Incompleto"), 
	FUND("Ensino Fundamental"), 
	MED_INC("Ensino Médio Incompleto"), 
	MED("Ensino Médio Completo"), 
	SUP("Superior"),
	MESTR("Mestrado"),
	DOUT("Doutorado");
	
	
	private String nome;
	
	private Escolaridade(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}
