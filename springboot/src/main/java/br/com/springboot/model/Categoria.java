package br.com.springboot.model;

public enum Categoria {
	CELULARES("Celulares"),
	ELETRODOMESTICOS("Eletrodomésticos"),
	INFORMATICA("Informática"),
	MOVEIS("Móveis");
	
	private String descricao;
	
	Categoria(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
