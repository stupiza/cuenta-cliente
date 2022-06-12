package com.api.cuentacliente.service;

import java.util.Date;

import com.api.cuentacliente.model.MovimientoModel;
import com.api.cuentacliente.model.MovimientoModelRequest;
import com.api.cuentacliente.model.ReporteModelRequest;
import com.api.cuentacliente.model.RetornoModel;

public interface IMovimientoService {
   /**
    * Lista todos los movimientos registrados
    * @return
    */
	public MovimientoModelRequest listarMovimientos();
	/**
	 * Registra movimiento por cada cuenta en base de datos
	 * @param movimientoModel
	 * @return
	 */
	public RetornoModel registrarMovimiento(MovimientoModel movimientoModel);
	/**
	 * Reporte de movimientos de cuenta por rango de fechas
	 * @param fechaDesde
	 * @param fechaHasta
	 * @param cliente
	 * @return
	 */
	public ReporteModelRequest reportarMovimientosPorFechaCliente(String fechaDesde, String fechaHasta, Integer cliente);
	/**
	 * Elimina un movimiento de la cuenta
	 * @param id
	 * @return
	 */
	public RetornoModel eliminarMovimiento(Integer id);
}
