package com.api.cuentacliente.model;

import java.util.List;

public class ReporteModel {

	private String cliente;
	private List<ReporteCuentaModel> cuenta;

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<ReporteCuentaModel> getCuenta() {
		return cuenta;
	}

	public void setCuenta(List<ReporteCuentaModel> cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "ReporteModel [cliente=" + cliente + ", cuenta=" + cuenta + "]";
	}

}
