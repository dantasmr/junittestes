package dantasmr.com.br.junittestes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import dantasmr.com.br.junittestes.mapper.DTOMapper;
import dantasmr.com.br.junittestes.model.ApiParametros;
import dantasmr.com.br.junittestes.model.DadosSaida;
import dantasmr.com.br.junittestes.model.FornecedorDTO;
import dantasmr.com.br.junittestes.model.ProdutoDTO;
import dantasmr.com.br.junittestes.model.ProdutoDetalheDTO;
import dantasmr.com.br.junittestes.service.ApiService;
import dantasmr.com.br.junittestes.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	public static final String PATH_API_PRODUTO = "path.produto";
	public static final String VERSAO_API_PRODUTO = "versao.produto";

	public static final String PATH_API_FORNECEDOR = "path.fornecedor";
	public static final String VERSAO_API_FORNECEDOR = "versao.fornecedor";

	@Autowired
	private ApiService apiService;
	
	@Autowired
	private DTOMapper dTOMapper;

	@Override
	public ProdutoDetalheDTO getProduto() {

		
		ProdutoDTO produtoDTO = getProdutoApi();
		FornecedorDTO fornecedorDTO = getFornecedorApi();
		
		ProdutoDetalheDTO produtoDetalheDTO = new ProdutoDetalheDTO();
		produtoDetalheDTO.setProduto(produtoDTO.getProduto());
		produtoDetalheDTO.setValor(produtoDTO.getValor());
		produtoDetalheDTO.setFornecedor(fornecedorDTO.getFornecedor());
		produtoDetalheDTO.setNregistro(fornecedorDTO.getNregistro());
		return produtoDetalheDTO;
			
		
	}
	
	private ProdutoDTO getProdutoApi() {
		ApiParametros apiParametros = new ApiParametros();
		apiParametros.setPath(PATH_API_PRODUTO);
		apiParametros.setVersao(VERSAO_API_PRODUTO);

		DadosSaida dadosSaida = apiService.get(apiParametros);
		if (dadosSaida.getStatusCode() != 200) {
			throw new RuntimeException("Erro ao pesquisar produto");
		}else {			
			return dTOMapper.parseDTO(dadosSaida.getBody(), new TypeReference<ProdutoDTO>(){});
		}
	}
	
	private FornecedorDTO getFornecedorApi() {
		ApiParametros apiParametros = new ApiParametros();
		apiParametros.setPath(PATH_API_FORNECEDOR);
		apiParametros.setVersao(VERSAO_API_FORNECEDOR);

		DadosSaida dadosSaida = apiService.get(apiParametros);
		if (dadosSaida.getStatusCode() != 200) {
			throw new RuntimeException("Erro ao pesquisar fornecedor");
		}else {			
			return dTOMapper.parseDTO(dadosSaida.getBody(), new TypeReference<FornecedorDTO>(){});
		}
	}

}
