package com.api.cuentacliente.model;

import java.util.Date;

public class MovimientoModel {

	private Integer codigoMovimiento;
	private Integer codigoCuenta;
	private Date fechaMovimiento;
	private String tipoMovimiento;
	private Double valorMovimiento;
	private Double saldoMovimiento;

	public Integer getCodigoMovimiento() {
		return codigoMovimiento;
	}

	public void setCodigoMovimiento(Integer codigoMovimiento) {
		this.codigoMovimiento = codigoMovimiento;
	}

	public Integer getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(Integer codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Double getValorMovimiento() {
		return valorMovimiento;
	}

	public void setValorMovimiento(Double valorMovimiento) {
		this.valorMovimiento = valorMovimiento;
	}

	public Double getSaldoMovimiento() {
		return saldoMovimiento;
	}

	public void setSaldoMovimiento(Double saldoMovimiento) {
		this.saldoMovimiento = saldoMovimiento;
	}

	@Override
	public String toString() {
		return "MovimientoModel [codigoMovimiento=" + codigoMovimiento + ", codigoCuenta=" + codigoCuenta
				+ ", fechaMovimiento=" + fechaMovimiento + ", tipoMovimiento=" + tipoMovimiento + ", valorMovimiento="
				+ valorMovimiento + ", saldoMovimiento=" + saldoMovimiento + "]";
	}
	
	

}
