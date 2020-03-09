package br.com.smanager.compra.endpoint.dto;

import java.util.List;

public class CompraDTOIn {
	private List<PedidoItem> itens;

	public List<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
	}
	
	
}
