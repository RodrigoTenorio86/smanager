package br.com.smanager.produto.endpoint.dto;

public class ItensDoPedidoDTO {
	private int quantidade;
	private long idProduto;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}


}
