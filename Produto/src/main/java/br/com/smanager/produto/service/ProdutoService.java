package br.com.smanager.produto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smanager.produto.endpoint.dto.ItensDoPedidoDTO;
import br.com.smanager.produto.model.Pedido;
import br.com.smanager.produto.model.PedidoItem;
import br.com.smanager.produto.model.Produto;
import br.com.smanager.produto.repository.PedidoRepository;
import br.com.smanager.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Produto getProduto(Long id) {
		return produtoRepository.findById(id).orElse(new Produto());
	}


	
	public Pedido realizaPedido(List<ItensDoPedidoDTO> itens) {
		List<PedidoItem>pedidoItems=toPedidoItem(itens);
		Pedido pedido=new Pedido(pedidoItems);
		return pedidoRepository.save(pedido);
	}
	
	
	private List<PedidoItem> toPedidoItem(List<ItensDoPedidoDTO> itens){
		List<Long> idsProdutos = itens.stream()
									  .map(item->item.getIdProduto())
									  .collect(Collectors.toList());
		
		List<Produto> produtos = produtoRepository.findByIdIn(idsProdutos);
		
		List<PedidoItem> pedidoItems = itens.stream()
											.map(item->{
												Produto produto = produtos.stream()
														                  .filter(p->p.getId()==item.getIdProduto())
														                  .findFirst()
														                  .get();
														PedidoItem pedidoItem = new PedidoItem();
														pedidoItem.setProduto(produto);
														pedidoItem.setQuantidade(item.getQuantidade());
														return pedidoItem;
											}).collect(Collectors.toList());
				return pedidoItems;
		
	}
	
	
}
