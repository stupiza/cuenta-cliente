package com.api.cuentacliente.service;


import java.util.Optional;

import com.api.cuentacliente.entity.Cliente;
import com.api.cuentacliente.model.ClienteModel;
import com.api.cuentacliente.model.ClienteModelRequest;
import com.api.cuentacliente.model.RetornoModel;

public interface IClienteService {
	/**
	 * Lista todos los clientes registrados
	 * @return
	 */
	public ClienteModelRequest listarClientes();
	/**
	 * Registra en la base de datos el cliente
	 * @param cliente
	 * @return
	 */
	public RetornoModel registrarCliente(ClienteModel cliente);
	/**
	 * Lista el cliente asociado al codigo de base de datos
	 * @param cliente
	 * @return
	 */
	public Optional<Cliente> listarClientePorCodigo(Integer cliente);

}
