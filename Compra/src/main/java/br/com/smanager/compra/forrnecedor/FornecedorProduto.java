package br.com.smanager.compra.forrnecedor;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.smanager.compra.endpoint.dto.Itens;
import br.com.smanager.compra.endpoint.dto.PedidoDTO;
import br.com.smanager.compra.endpoint.dto.ProdutoDTO;

@FeignClient("produto")
public interface FornecedorProduto {
	@GetMapping("/v1/produtos/{id}")
	public ProdutoDTO getProduto(@PathVariable("id") Long id);

	@PostMapping("/v1/produtos")
	public PedidoDTO realizaPedido(@RequestBody List<Itens> produtos);
}
