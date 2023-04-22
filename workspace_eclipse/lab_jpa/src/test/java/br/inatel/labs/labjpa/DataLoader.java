package br.inatel.labs.labjpa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.labjpa.entity.Fornecedor;
import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.entity.Produto;
import br.inatel.labs.labjpa.service.FornecedorService;
import br.inatel.labs.labjpa.service.NotaCompraService;
import br.inatel.labs.labjpa.service.ProdutoService;

//Para mudar o nome de uma classe usamos ctrl + 1 nela
//@SpringBootTest
class DataLoader {

	//Injetando artefato do spring
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@Autowired
	private NotaCompraService notaCompraService;
	
//@Test
	void load() {
		//Instanciando produtos
		Produto p1 = new Produto("Furadeira");
		Produto p2 = new Produto("Lixadeira");
		Produto p3 = new Produto("Plaina");
		Produto p4 = new Produto("Tupia");
		Produto p5 = new Produto("Serra Circular");
		
		//Salvando cada produto
		p1 = produtoService.salvar(p1);
		p2 = produtoService.salvar(p2);
		p3 = produtoService.salvar(p3);
		p4 = produtoService.salvar(p4);
		p5 = produtoService.salvar(p5);
		
		//Listando produtos
		List<Produto> listaProduto = produtoService.listar();
		listaProduto.forEach(System.out::println);
	
		//Instanciando fornecedores
		Fornecedor f1 = new Fornecedor("Gasômetro Madeiras");
		Fornecedor f2 = new Fornecedor("Loja do Mecânico");
		
		//Salvando fornecedor
		f1 = fornecedorService.salvar(f1);
		f2 = fornecedorService.salvar(f2);
		
		//Listando fornecedores
		List<Fornecedor> listaFornecedor = fornecedorService.listar();
		listaFornecedor.forEach(System.out::println);
		
		//Instanciando NotaCompra
		NotaCompra nc1 = new NotaCompra(f1,LocalDate.of(2021, 1, 15));
		NotaCompra nc2 = new NotaCompra(f2 ,LocalDate.of(2022, 2, 20));
		
		//Salvando NotaCompra
		nc1 = notaCompraService.salvarNotaCompra(nc1);
		nc2 = notaCompraService.salvarNotaCompra(nc2);
		
		//Listando NotaCompra
		List<NotaCompra> notaCompra = notaCompraService.listarNotaCompra();
		notaCompra.forEach(System.out::println);
		
		//NotaCompra ITEM
		NotaCompraItem i1_1 = new NotaCompraItem(nc1, p1, new BigDecimal("300.00"), 2);
		NotaCompraItem il_2 = new NotaCompraItem(nc1,p2, new BigDecimal("1000.00"), 1);
		NotaCompraItem il_3 = new NotaCompraItem(nc1,p3, new BigDecimal("500.00"), 3);
		i1_1 = notaCompraService.salvarNotaCompraItem(i1_1);
		il_2 = notaCompraService.salvarNotaCompraItem(il_2);
		il_3 = notaCompraService.salvarNotaCompraItem(il_3);
		
		NotaCompraItem i2_1 = new NotaCompraItem(nc2, p4, new BigDecimal("400.00"), 7);
		NotaCompraItem i2_2 = new NotaCompraItem(nc2, p2, new BigDecimal("1000.00"), 2);
		NotaCompraItem i2_3 = new NotaCompraItem(nc2, p5, new BigDecimal("700.00"), 1);
		i2_1 = notaCompraService.salvarNotaCompraItem(i2_1);
		i2_2 = notaCompraService.salvarNotaCompraItem(i2_2);
		i2_3 = notaCompraService.salvarNotaCompraItem(i2_3);
		
		notaCompraService.listarNotaCompraItem().forEach(System.out::println);
		
	}

}