package br.com.smanager.produto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.smanager.produto.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	List<Produto> findByIdIn(List<Long> id);
}
