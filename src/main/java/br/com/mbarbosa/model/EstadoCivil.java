package br.com.mbarbosa.model;

public enum EstadoCivil {
	CASADO("Casado"),
	SOLTEIRO("Solteiro");
	
	private String descricao;
	
	EstadoCivil(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
