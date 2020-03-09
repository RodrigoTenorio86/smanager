package br.com.smanager.compra.endpoint.dto;

import java.util.List;



public class PedidoDTO {
	private Long id;

	private List<PedidoItem> itens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
	}



}
