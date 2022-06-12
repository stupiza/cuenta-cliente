package com.api.cuentacliente.model;

import java.util.List;

public class MovimientoModelRequest {
	private List<MovimientoModel> movimiento;
	private RetornoModel mensaje;

	public List<MovimientoModel> getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(List<MovimientoModel> movimiento) {
		this.movimiento = movimiento;
	}

	public RetornoModel getMensaje() {
		return mensaje;
	}

	public void setMensaje(RetornoModel mensaje) {
		this.mensaje = mensaje;
	}

}
