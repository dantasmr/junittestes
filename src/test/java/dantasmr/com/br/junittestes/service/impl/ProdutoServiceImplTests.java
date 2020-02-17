package dantasmr.com.br.junittestes.service.impl;


import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static dantasmr.com.br.junittestes.service.impl.ProdutoServiceImpl.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import dantasmr.com.br.junittestes.mapper.DTOMapper;
import dantasmr.com.br.junittestes.model.ApiParametros;
import dantasmr.com.br.junittestes.model.DadosSaida;
import dantasmr.com.br.junittestes.model.FornecedorDTO;
import dantasmr.com.br.junittestes.model.ProdutoDTO;
import dantasmr.com.br.junittestes.model.ProdutoDetalheDTO;
import dantasmr.com.br.junittestes.service.ApiService;

@RunWith(MockitoJUnitRunner.class)
public class ProdutoServiceImplTests {
	
	private final static ObjectMapper OBJECTMAPPER = new ObjectMapper();
	
	private final static String PRODUTO_JSON =  "{\"produto\":\"Produto 1\",\"valor\":\"10 reais\"}";
	private final static String FORNECEDOR_JSON = "{\"fornecedor\": \"fornecedor\",\"nregistro\": \"12233\"}";
	
	@InjectMocks
	private ProdutoServiceImpl produtoServiceImpl;
	
	@Mock
	private ApiService apiService;
	
	@Spy
	private DTOMapper dTOMapper = new DTOMapper();
	
	@Before
	public void inicio() {
		
		when(apiService.get(any(ApiParametros.class))).thenAnswer(i -> {
			DadosSaida dadosSaida = new DadosSaida();
			
			ApiParametros apiParametros = i.getArgument(0);
			final String path = apiParametros.getPath();
			
			switch (path) {
			
			case PATH_API_PRODUTO:
				ProdutoDTO produto = OBJECTMAPPER.readValue(PRODUTO_JSON, ProdutoDTO.class);
				dadosSaida.setBody(produto);
				break;
			case PATH_API_FORNECEDOR:
				FornecedorDTO fornecedorDTO = OBJECTMAPPER.readValue(FORNECEDOR_JSON, FornecedorDTO.class);
				dadosSaida.setBody(fornecedorDTO);
				break;
			}
			
			dadosSaida.setStatusCode(200);
			return dadosSaida;
						
	    });
	}
	
	@Test
	public void testeProduto() {
		ProdutoDetalheDTO produtoDetalheDTO = produtoServiceImpl.getProduto();
		Assert.assertNotNull(produtoDetalheDTO);
	}
	
}
