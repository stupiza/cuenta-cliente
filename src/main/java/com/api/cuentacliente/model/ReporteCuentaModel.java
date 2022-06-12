package com.api.cuentacliente.model;

import java.util.List;

public class ReporteCuentaModel {
    
	private String numeroCuenta;
	private String tipoCuenta;
	private Double saldoInicial;
	private boolean estado;
	private List<ReporteMovimientoModel> movimiento;

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<ReporteMovimientoModel> getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(List<ReporteMovimientoModel> movimiento) {
		this.movimiento = movimiento;
	}

	@Override
	public String toString() {
		return "ReporteCuentaModel [numeroCuenta=" + numeroCuenta + ", tipoCuenta=" + tipoCuenta + ", saldoInicial="
				+ saldoInicial + ", estado=" + estado + ", movimiento=" + movimiento + "]";
	}

	

}
