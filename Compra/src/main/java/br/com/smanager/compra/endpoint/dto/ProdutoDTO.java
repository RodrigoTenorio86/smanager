package br.com.smanager.compra.endpoint.dto;

import java.math.BigDecimal;

import br.com.smanager.compra.descricao.Genero;

public class ProdutoDTO {
	private String descricao;
	private Genero genero;
	private int importacao;
	private BigDecimal preco;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public int getImportacao() {
		return importacao;
	}
	public void setImportacao(int importacao) {
		this.importacao = importacao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	
}
