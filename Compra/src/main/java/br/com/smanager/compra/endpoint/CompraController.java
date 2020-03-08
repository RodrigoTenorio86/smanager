package br.com.smanager.compra.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.smanager.compra.endpoint.dto.CompraDTOIn;
import br.com.smanager.compra.endpoint.dto.Itens;
import br.com.smanager.compra.model.ResultadoTaxa;
import br.com.smanager.compra.service.CompraService;

@RestController
@RequestMapping("/v1/compra")
public class CompraController {
	@Autowired
	private CompraService compraService;
	
	@PostMapping
	public void realizaCompra(@RequestBody CompraDTOIn compraDTOIn) {
		ResultadoTaxa resultado=        compraService.realizaCompra(compraDTOIn);
		
	}
}
