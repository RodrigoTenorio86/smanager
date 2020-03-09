package br.com.smanager.compra.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import br.com.smanager.compra.descricao.Genero;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.smanager.compra.endpoint.dto.CompraDTOIn;
import br.com.smanager.compra.endpoint.dto.PedidoDTO;
import br.com.smanager.compra.forrnecedor.FornecedorProduto;
import br.com.smanager.compra.model.ItensDaNota;
import br.com.smanager.compra.model.Nota;
import br.com.smanager.compra.model.ResultadoTaxa;

@Service
public class CompraService {
	
	private static final Logger LOG= LoggerFactory.getLogger(CompraService.class);
	
	//@Autowired
	//private DiscoveryClient eurekaClient;
	@Autowired
	private FornecedorProduto fornecedorProduto;
	
		

//	@HystrixCommand(fallbackMethod = "realizaCompraErro")
	public Nota realizaCompra(CompraDTOIn compraDTOIn) {	

		
		return toNotaCompra( compraDTOIn);
	}
	
	
	private Nota toNotaCompra(CompraDTOIn compraDTOIn) {
		 ResultadoTaxa taResultadoTaxa = new ResultadoTaxa();
		
		PedidoDTO compra=fornecedorProduto.realizaPedido(compraDTOIn.getItens());
		

		

		
		LOG.info("compra______ {}",compra.getItens().stream().filter(item->item.getIdProduto()==1l).findFirst());
		
		List<ItensDaNota> itensDaNotas=compra.getItens().stream()
														.map(item->{
															ItensDaNota itensDaNota= new ItensDaNota();
																		itensDaNota.setDescricao(item.getProduto().getDescricao());
																		itensDaNota.setPreco(item.getProduto().getPreco());
																		itensDaNota.setQuantidade(item.getQuantidade());
																		itensDaNota.setImportado(item.getProduto().getImportacao());
																		itensDaNota.setGenero(item.getProduto().getGenero());
																		return itensDaNota;})
														.collect(Collectors.toList());
	
		
		BigDecimal totalSemTaxas=	taResultadoTaxa.calcularTotal(itensDaNotas);
									taResultadoTaxa.calcularTaxaProduto( itensDaNotas);
									taResultadoTaxa.calcularTaxaImportacao(itensDaNotas);
		BigDecimal Taxas=	taResultadoTaxa.calcularTotal(itensDaNotas);
		
		
				
		
		Nota nota=new Nota(itensDaNotas,Taxas.subtract(totalSemTaxas),Taxas);
		
		return nota;
	}
	
	public ResultadoTaxa  realizaCompraErro(CompraDTOIn compraDTOIn) {
		ResultadoTaxa resultadoTaxa= new ResultadoTaxa();
		LOG.info("Metodo de Fall BAcK.....");
		return resultadoTaxa;
		
	}
}
