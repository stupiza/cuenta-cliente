package com.api.cuentacliente.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.cuentacliente.model.CuentaModel;
import com.api.cuentacliente.model.CuentaModelRequest;
import com.api.cuentacliente.model.RetornoModel;
import com.api.cuentacliente.service.ICuentaService;


@RestController
@RequestMapping("/api/cuenta")
public class CuentaController {

	@Autowired	
	private ICuentaService cuentaServiceImp;

	public static Log log = LogFactory.getLog(CuentaController.class);

	@PostMapping("/registrar")
	public RetornoModel ingresarCuenta(@RequestBody CuentaModel cuentaModel) {
		return cuentaServiceImp.registrarCuenta(cuentaModel);
	}

	@GetMapping("/listar")
	public CuentaModelRequest listarCuentas() {
		return cuentaServiceImp.listarCuentas();
	}

	@PutMapping("/actualizar")
	public RetornoModel actualizarCuenta(@RequestBody CuentaModel cuentaModel) {
		return cuentaServiceImp.registrarCuenta(cuentaModel);
	}
	
	

}
