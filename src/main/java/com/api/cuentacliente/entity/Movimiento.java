package com.api.cuentacliente.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "cc_movimiento")
@NamedQueries({
    @NamedQuery(name = "Movimiento.findMovimientoByCuentaDebito", query = "SELECT c FROM Movimiento c where c.cuenta.codigoCuenta = ?1 and c.tipoMovimiento = 'D'"),
    @NamedQuery(name = "Movimiento.findMovimientoByCuenta", query = "SELECT c FROM Movimiento c where c.cuenta.codigoCuenta = ?1 and c.fechaMovimiento >= ?2 and c.fechaMovimiento <= ?3  ")
    
})
public class Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mo_codigo")
	private Integer codigoMovimiento;

	@ManyToOne // (optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "cu_codigo")
	private Cuenta cuenta;

	@Column(name = "mo_fecha")
	private Date fechaMovimiento;

	@Column(name = "mo_tipo_mov")
	private String tipoMovimiento;

	@Column(name = "mo_valor")
	private Double valorMovimiento;

	@Column(name = "mo_saldo")
	private Double saldoMovimiento;

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Integer getCodigoMovimiento() {
		return codigoMovimiento;
	}

	public void setCodigoMovimiento(Integer codigoMovimiento) {
		this.codigoMovimiento = codigoMovimiento;
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
		return "Movimiento [codigoMovimiento=" + codigoMovimiento + ", fechaMovimiento=" + fechaMovimiento
				+ ", tipoMovimiento=" + tipoMovimiento + ", valorMovimiento=" + valorMovimiento + ", saldoMovimiento="
				+ saldoMovimiento + "]";
	}

}
