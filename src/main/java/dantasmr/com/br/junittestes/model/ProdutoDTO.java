package dantasmr.com.br.junittestes.model;

import java.io.Serializable;

public class ProdutoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2327644834988934659L;
	
	private String produto;
	private String valor;
	
	
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
	
	

}
