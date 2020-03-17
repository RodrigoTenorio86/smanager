package br.com.smanager.compra.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
//	private static final BigDecimal ARRENDONDAR = new BigDecimal(0.05);
	private static final BigDecimal ARRENDONDAR = new BigDecimal(20);	
	

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
		
		itensDaNotas.stream().filter(item->item.getGenero().equals(Genero.ELETRODOMESTICOS)||item.getGenero().equals(Genero.COSMETICOS) )
                             .forEach(item->item.setPreco( item.getPreco().add(arrendondamento(item.getPreco().multiply(TAXA_PRODUTO)))));
	}

	public void calcularTaxaImportacao(List<ItensDaNota> itensDaNotas) {
		itensDaNotas.stream().filter(item->item.getImportado()==1)
							 .forEach(item->item.setPreco(item.getPreco().add(arrendondamento(item.getPreco().multiply(IMPORTACAO)))));			
		
	}
	
	private BigDecimal arrendondamento(BigDecimal valor) {
	 //   valor = valor.divide(ARRENDONDAR);
	 //   valor = new BigDecimal(Math.ceil(valor.doubleValue()));	
	 //   valor = valor.multiply(ARRENDONDAR);
	 //	valor = valor.multiply(ARRENDONDAR).setScale(0, RoundingMode.CEILING).divide(ARRENDONDAR).setScale(2);
		valor = valor.multiply(ARRENDONDAR).setScale(0,RoundingMode.HALF_EVEN).divide(ARRENDONDAR).setScale(2);
		return valor;
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