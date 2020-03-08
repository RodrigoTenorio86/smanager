package br.com.smanager.produto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.smanager.produto.model.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido	,Long>{

}
