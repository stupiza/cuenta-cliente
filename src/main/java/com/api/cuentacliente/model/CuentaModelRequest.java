package com.api.cuentacliente.model;

import java.util.List;

public class CuentaModelRequest {

	private List<CuentaModel> cuenta;
	private RetornoModel mensaje;

	public List<CuentaModel> getCuenta() {
		return cuenta;
	}

	public void setCuenta(List<CuentaModel> cuenta) {
		this.cuenta = cuenta;
	}

	public RetornoModel getMensaje() {
		return mensaje;
	}

	public void setMensaje(RetornoModel mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "CuentaModelRequest [cuenta=" + cuenta + ", mensaje=" + mensaje + "]";
	}

}
