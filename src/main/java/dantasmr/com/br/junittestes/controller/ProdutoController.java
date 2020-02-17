package dantasmr.com.br.junittestes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dantasmr.com.br.junittestes.model.ProdutoDetalheDTO;
import dantasmr.com.br.junittestes.service.ProdutoService;

@RestController
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/produto")
    public ProdutoDetalheDTO getProdutoDetalhe() {
       return produtoService.getProduto();
    }

}
