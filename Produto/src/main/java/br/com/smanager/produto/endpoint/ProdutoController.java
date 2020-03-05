package br.com.smanager.produto.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.smanager.produto.service.ProdutoService;

@RequestMapping("/v1/produtos")
@RestController
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
}
