package br.com.smanager.compra.model;

import java.math.BigDecimal;
import java.util.List;

import br.com.smanager.compra.endpoint.dto.ProdutoDTO;

public class ResultadoTaxa {
	private List<ProdutoDTO> produtoDTOs;
	private BigDecimal taxaDeImposto;
	private BigDecimal total;

	public List<ProdutoDTO> getProdutoDTOs() {
		return produtoDTOs;
	}

	public void setProdutoDTOs(List<ProdutoDTO> produtoDTOs) {
		this.produtoDTOs = produtoDTOs;
	}

	public BigDecimal getTaxaDeImposto() {
		return taxaDeImposto;
	}

	public void setTaxaDeImposto(BigDecimal taxaDeImposto) {
		this.taxaDeImposto = taxaDeImposto;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
