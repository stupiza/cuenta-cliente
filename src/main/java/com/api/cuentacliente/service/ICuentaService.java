package com.api.cuentacliente.service;

import java.util.List;
import java.util.Optional;

import com.api.cuentacliente.entity.Cuenta;
import com.api.cuentacliente.model.CuentaModel;
import com.api.cuentacliente.model.CuentaModelRequest;
import com.api.cuentacliente.model.RetornoModel;

public interface ICuentaService {
	/**
	 * Lista todas las cuentas registradas
	 * @return
	 */
	public CuentaModelRequest listarCuentas();
	/**
	 * Registra la cuenta del cliene en base de datos
	 * @param cuenta
	 * @return
	 */
	public RetornoModel registrarCuenta(CuentaModel cuenta);
	/**
	 * Lista la cuenta asociada al cliente
	 * @param cliente
	 * @return
	 */
	public List<Cuenta> listarCuentasPorCliente(Integer cliente);
	/**
	 * Lista la cuenta asociada al codigo de base de datos
	 * @param cuenta
	 * @return
	 */
	public Optional<Cuenta> listarCuentasPorCodigo(Integer cuenta);
}
