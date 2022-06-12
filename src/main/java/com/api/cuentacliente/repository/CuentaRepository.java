package com.api.cuentacliente.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.cuentacliente.entity.Cuenta;


@Repository("cuentaRepository")
public interface CuentaRepository extends JpaRepository<Cuenta, Serializable>{

	public List<Cuenta> findCuentaByCliente(Integer cliente);
}
