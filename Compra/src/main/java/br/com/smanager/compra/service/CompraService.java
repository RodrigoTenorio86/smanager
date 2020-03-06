package br.com.smanager.compra.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import br.com.smanager.compra.forrnecedor.FornecedorProduto;

@Service
public class CompraService {
	
	//@Autowired
	//private DiscoveryClient eurekaClient;
	@Autowired
	private FornecedorProduto fornecedorProduto;

	public void realizaCompra() {
		
	}
}
