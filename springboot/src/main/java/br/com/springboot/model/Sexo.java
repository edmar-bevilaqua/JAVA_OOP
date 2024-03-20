package br.com.springboot.model;

public enum Sexo {
	MASCULINO("Masculino"),
	FEMININO("Feminino"),
	OUTRO("Non-binary");
	
	private String descricao;
	
	Sexo(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
}
