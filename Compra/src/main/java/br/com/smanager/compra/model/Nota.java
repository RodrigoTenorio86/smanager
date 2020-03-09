package br.com.smanager.compra.model;

import java.math.BigDecimal;
import java.util.List;

public class Nota {
	private List<ItensDaNota>  itens;
	private BigDecimal totalComImposto;
	private BigDecimal total;
	
	
	public Nota() {
	}


	public Nota(List<ItensDaNota> itens, BigDecimal totalComImposto, BigDecimal total) {
		this.itens = itens;
		this.totalComImposto = totalComImposto;
		this.total = total;
	}


	public List<ItensDaNota> getItens() {
		return itens;
	}


	public void setItens(List<ItensDaNota> itens) {
		this.itens = itens;
	}


	public BigDecimal getTotalComImposto() {
		return totalComImposto;
	}


	public void setTotalComImposto(BigDecimal totalComImposto) {
		this.totalComImposto = totalComImposto;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	

	
}
