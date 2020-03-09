package br.com.smanager.compra.model;

import java.math.BigDecimal;

import br.com.smanager.compra.descricao.Genero;

public class ItensDaNota {
	private int quantidade;
	private String descricao;
	private BigDecimal preco;
	private Genero genero;
	private int importado;
	
	
	
	public ItensDaNota(int quantidade, String descricao, BigDecimal preco, Genero genero, int importado) {
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.preco = preco;
		this.genero = genero;
		this.importado = importado;
	}

	public ItensDaNota(int quantidade, String descricao, BigDecimal preco) {
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public ItensDaNota() {
	}

	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getImportado() {
		return importado;
	}

	public void setImportado(int importado) {
		this.importado = importado;
	}
	
	
	
}
