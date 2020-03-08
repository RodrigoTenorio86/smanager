package br.com.smanager.compra.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.smanager.compra.endpoint.dto.CompraDTOIn;
import br.com.smanager.compra.endpoint.dto.PedidoDTO;
import br.com.smanager.compra.forrnecedor.FornecedorProduto;
import br.com.smanager.compra.model.ResultadoTaxa;

@Service
public class CompraService {
	
	private static final Logger LOG= LoggerFactory.getLogger(CompraService.class);
	
	//@Autowired
	//private DiscoveryClient eurekaClient;
	@Autowired
	private FornecedorProduto fornecedorProduto;

	@HystrixCommand(fallbackMethod = "realizaCompraErro")
	public ResultadoTaxa realizaCompra(CompraDTOIn compraDTOIn) {
		
		PedidoDTO compra=fornecedorProduto.realizaPedido(compraDTOIn.getItens());
		//System.out.println(compra.getId());
		LOG.info("compra_");
		return null;
	}
	
	
	
	
	public ResultadoTaxa  realizaCompraErro(CompraDTOIn compraDTOIn) {
		ResultadoTaxa resultadoTaxa= new ResultadoTaxa();
		LOG.info("Metodo de Fall BAcK.....");
		return resultadoTaxa;
		
	}
}
