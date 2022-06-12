package com.api.cuentacliente.model;

public class CuentaModel {

	private Integer codigoCuenta;
	private Integer codigoCliente;
	private String numeroCuenta;
	private String tipoCuenta;
	private Double saldoCuenta;
	private boolean estadoCuenta;

	public Integer getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(Integer codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

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

	public Double getSaldoCuenta() {
		return saldoCuenta;
	}

	public void setSaldoCuenta(Double saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}

	public boolean isEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(boolean estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	@Override
	public String toString() {
		return "CuentaModel [codigoCuenta=" + codigoCuenta + ", codigoCliente=" + codigoCliente + ", numeroCuenta="
				+ numeroCuenta + ", tipoCuenta=" + tipoCuenta + ", saldoCuenta=" + saldoCuenta + ", estadoCuenta="
				+ estadoCuenta + "]";
	}

}
