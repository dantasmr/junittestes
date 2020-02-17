package dantasmr.com.br.junittestes.service;

import dantasmr.com.br.junittestes.model.ApiParametros;
import dantasmr.com.br.junittestes.model.DadosSaida;

public interface ApiService {
	
	public DadosSaida get(ApiParametros apiParametros);

}
