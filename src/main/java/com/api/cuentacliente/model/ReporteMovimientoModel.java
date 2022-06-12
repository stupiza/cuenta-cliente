package com.api.cuentacliente.model;

public class ReporteMovimientoModel {
	
	private String fecha;
	private Double movimiento;
	private Double saldoDisponible;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Double movimiento) {
		this.movimiento = movimiento;
	}

	public Double getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(Double saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}

	@Override
	public String toString() {
		return "ReporteMovimientoModel [fecha=" + fecha + ", movimiento=" + movimiento + ", saldoDisponible="
				+ saldoDisponible + "]";
	}

}
