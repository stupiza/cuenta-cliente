package com.api.cuentacliente.model;

import java.util.List;

public class ClienteModelRequest {

	private List<ClienteModel> cliente;
	private RetornoModel mensaje;

	public List<ClienteModel> getCliente() {
		return cliente;
	}

	public void setCliente(List<ClienteModel> cliente) {
		this.cliente = cliente;
	}

	public RetornoModel getMensaje() {
		return mensaje;
	}

	public void setMensaje(RetornoModel mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "ClienteModelRequest [cliente=" + cliente + ", mensaje=" + mensaje + "]";
	}

}
