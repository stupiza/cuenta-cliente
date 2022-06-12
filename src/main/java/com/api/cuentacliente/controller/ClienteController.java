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

import com.api.cuentacliente.model.ClienteModel;
import com.api.cuentacliente.model.ClienteModelRequest;
import com.api.cuentacliente.model.RetornoModel;
import com.api.cuentacliente.service.IClienteService;



@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired	
	private IClienteService clienteServiceImp;

	public static Log log = LogFactory.getLog(ClienteController.class);

	@PostMapping("/registrar")
	public RetornoModel ingresarCliente(@RequestBody ClienteModel clienteModel) {			 
		return clienteServiceImp.registrarCliente(clienteModel);
	}
	
	@GetMapping("/listar")
	public ClienteModelRequest listarClientes() {			
		return  clienteServiceImp.listarClientes();
	}
	
	@PutMapping("/actualizar")
	public RetornoModel actualizarCliente(@RequestBody ClienteModel clienteModel) {			
		return clienteServiceImp.registrarCliente(clienteModel);
	}
	
	
}