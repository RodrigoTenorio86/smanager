package br.com.smanager.produto.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.smanager.produto.model.Produto;
import br.com.smanager.produto.service.ProdutoService;

@RequestMapping("/v1/produtos")
@RestController
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProduto(@PathVariable Long id) {
		Produto produto= produtoService.getProduto(id);
		return new ResponseEntity<>(produto, HttpStatus.OK);
	}
	
	
	
	
}
