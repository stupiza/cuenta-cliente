package com.api.cuentacliente.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.cuentacliente.entity.Movimiento;


@Repository("movimientoRepository")
public interface MovimientoRepository extends JpaRepository<Movimiento, Serializable> {

	 public List<Movimiento> findMovimientoByCuentaDebito(Integer cuenta);
	 
	 public List<Movimiento> findMovimientoByCuenta(Integer cuenta, Date fechaInicio, Date fechafin);
}
