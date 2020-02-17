package dantasmr.com.br.junittestes.model;

import java.io.Serializable;

public class ProdutoDetalheDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3201472067620444186L;
	
	
	private String produto;
	private String valor;
	private String fornecedor;
	private String nregistro;
	
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
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
