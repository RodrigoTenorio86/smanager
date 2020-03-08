package br.com.smanager.produto.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.smanager.produto.endpoint.dto.ItensDoPedidoDTO;
import br.com.smanager.produto.model.Pedido;
import br.com.smanager.produto.model.Produto;
import br.com.smanager.produto.service.ProdutoService;

@RequestMapping("/v1/produtos")
@RestController
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getProduto(@PathVariable("id") Long id) {
		Produto produto= produtoService.getProduto(id);
		return new ResponseEntity<>(produto, HttpStatus.OK);
	}
	

	
	@PostMapping
	public ResponseEntity<?> realizaPedido(@RequestBody List<ItensDoPedidoDTO> produtos){
		Pedido pedido = produtoService.realizaPedido(produtos);
		return new ResponseEntity<>(pedido,HttpStatus.OK);		
	}
	
	//@PostMapping
	//public Pedido realizaPedido(@RequestBody List<ItensDoPedidoDTO> produtos){
	//	Pedido pedido = produtoService.realizaPedido(produtos);
	//	return pedido;
    //}
	
	
}
