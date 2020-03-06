package br.com.smanager.compra.forrnecedor;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("produto")
public interface FornecedorProduto {

}
