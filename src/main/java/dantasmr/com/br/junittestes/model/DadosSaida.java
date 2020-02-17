package dantasmr.com.br.junittestes.model;

import java.io.Serializable;

public class DadosSaida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8891996441725247758L;
	
	private int statusCode;
	private Object body;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	
	
	

}
