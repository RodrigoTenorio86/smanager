package br.com.smanager.compra.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.smanager.compra.descricao.Genero;
@Service
public class ResultadoTaxa {
	private BigDecimal totalSemImposto;
	private BigDecimal totalComImposto;
	private BigDecimal total;
	
	private static final BigDecimal TAXA_PRODUTO= new BigDecimal(0.1);
	private static final BigDecimal IMPORTACAO = new BigDecimal(0.05); 
	
	

	public BigDecimal getTotalSemImposto() {
		return totalSemImposto;
	}

	public void setTotalSemImposto(BigDecimal totalSemImposto) {
		this.totalSemImposto = totalSemImposto;
	}




	public BigDecimal getTotalComImposto() {
		return totalComImposto;
	}

	public void setTotalComImposto(BigDecimal totalComImposto) {
		this.totalComImposto = totalComImposto;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public void calcularTaxaProduto(List<ItensDaNota> itensDaNotas) {
		
		itensDaNotas.stream().filter(item->item.getGenero().equals(Genero.ELETRODOMESTICOS) )
                             .forEach(item->item.setPreco( item.getPreco().add(item.getPreco().multiply(TAXA_PRODUTO)).setScale(2, BigDecimal.ROUND_HALF_DOWN)));
	}

	public void calcularTaxaImportacao(List<ItensDaNota> itensDaNotas) {
		itensDaNotas.stream().filter(item->item.getImportado()==1)
							 .forEach(item->item.setPreco(item.getPreco().add(item.getPreco().multiply(IMPORTACAO)).setScale(2,BigDecimal.ROUND_HALF_DOWN)));			
		
	}



	public BigDecimal calcularTotal(List<ItensDaNota> itensDaNotas) {
		this.total =      itensDaNotas.stream()
									  .map(item->item.getPreco())
									  .reduce(BigDecimal.ZERO, BigDecimal::add);
		return this.total;
		
	}

	public void calcularImpostoVenda() {
	             	this.totalComImposto= this.total.subtract(this.totalSemImposto);
		
	}

}
