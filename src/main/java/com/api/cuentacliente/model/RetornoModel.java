package com.api.cuentacliente.model;

public class RetornoModel {

	private int codigo;
	private String mensaje;

	public RetornoModel() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "RetornoModel [codigo=" + codigo + ", mensaje=" + mensaje + "]";
	}

}
