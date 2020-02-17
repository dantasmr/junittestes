package dantasmr.com.br.junittestes.service.impl;

import org.springframework.stereotype.Service;

import dantasmr.com.br.junittestes.model.ApiParametros;
import dantasmr.com.br.junittestes.model.DadosSaida;
import dantasmr.com.br.junittestes.model.FornecedorDTO;
import dantasmr.com.br.junittestes.model.ProdutoDTO;
import dantasmr.com.br.junittestes.service.ApiService;
import static dantasmr.com.br.junittestes.service.impl.ProdutoServiceImpl.*;
@Service
public class ApiServiceImpl implements ApiService{
	
	@Override
	public DadosSaida get(ApiParametros apiParametros) {
		DadosSaida dadosSaida = new DadosSaida();
		dadosSaida.setStatusCode(200);
		
		
		if (PATH_API_PRODUTO.equals(apiParametros.getPath())) {
			ProdutoDTO produto = new ProdutoDTO();
			produto.setProduto("Produto 1");
			produto.setValor("10 reais");
			dadosSaida.setBody(produto);
		}else {
			FornecedorDTO fornecedor = new FornecedorDTO();
			fornecedor.setFornecedor("Fornecedor xpto");
			fornecedor.setNregistro("registro.1223");
			dadosSaida.setBody(fornecedor);
		}
		
		return dadosSaida;
	}

}
