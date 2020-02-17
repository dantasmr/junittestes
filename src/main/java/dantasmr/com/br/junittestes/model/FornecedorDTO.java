package dantasmr.com.br.junittestes.model;

import java.io.Serializable;

public class FornecedorDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7344546519854226194L;
	private String fornecedor;
	private String nregistro;
	
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public String getNregistro() {
		return nregistro;
	}
	public void setNregistro(String nregistro) {
		this.nregistro = nregistro;
	}
	
	

}
