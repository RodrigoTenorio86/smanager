package br.com.smanager.compra.endpoint.dto;

import java.math.BigDecimal;

public class ProdutoDTO {
	private String descricao;
	private BigDecimal preco;

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

}
