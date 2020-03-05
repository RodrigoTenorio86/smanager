package br.com.smanager.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smanager.produto.model.Produto;
import br.com.smanager.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;
	
	public Produto getProduto(Long id) {
		return repository.getOne(id);
	}
}
