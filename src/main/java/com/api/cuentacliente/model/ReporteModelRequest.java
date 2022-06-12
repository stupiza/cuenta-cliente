package com.api.cuentacliente.model;

import java.util.List;

public class ReporteModelRequest {

	private List<ReporteModel> movimiento;
	private RetornoModel mensaje;

	public List<ReporteModel> getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(List<ReporteModel> movimiento) {
		this.movimiento = movimiento;
	}

	public RetornoModel getMensaje() {
		return mensaje;
	}

	public void setMensaje(RetornoModel mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "ReporteModelRequest [movimiento=" + movimiento + ", mensaje=" + mensaje + "]";
	}

}
