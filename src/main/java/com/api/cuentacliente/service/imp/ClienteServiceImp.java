package com.api.cuentacliente.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.api.cuentacliente.entity.Cliente;
import com.api.cuentacliente.model.ClienteModel;
import com.api.cuentacliente.model.ClienteModelRequest;
import com.api.cuentacliente.model.RetornoModel;
import com.api.cuentacliente.repository.ClienteRepository;
import com.api.cuentacliente.service.IClienteService;
import com.api.cuentacliente.utils.ConverterDTO;



@Service("clienteservice")
public class ClienteServiceImp implements IClienteService {

	@Autowired()
	@Qualifier("clienteRepository")
	ClienteRepository clienteRepository;

	@Autowired
	@Qualifier("converterDTO")
	private ConverterDTO converterDTO;

	/**
	 * Listar todos los clientes
	 */
	@Override
	public ClienteModelRequest listarClientes() {
		ClienteModelRequest clienteModelRequest = new ClienteModelRequest();
		List<ClienteModel> listaclienteModel = new ArrayList<>();
		List<Cliente> resultadoCliente = clienteRepository.findAll();
		
		RetornoModel retornoModel = new RetornoModel();
		try {

			if (resultadoCliente.isEmpty()) {
				retornoModel.setCodigo(1);
				retornoModel.setMensaje("NO EXISTEN REGISTROS!!");
				clienteModelRequest.setMensaje(retornoModel);
				return clienteModelRequest;
			}
			for (Cliente poi : resultadoCliente) {
				ClienteModel pmi = (ClienteModel) converterDTO.converterToModel(poi, ClienteModel.class);
				listaclienteModel.add(pmi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		retornoModel.setCodigo(0);
		retornoModel.setMensaje("RECUPERADOS!!");
		clienteModelRequest.setMensaje(retornoModel);
		clienteModelRequest.setCliente(listaclienteModel);
		return clienteModelRequest;
	}

	/**
	 * Registro de nuevo cliente
	 */
	@Override
	public RetornoModel registrarCliente(ClienteModel clienteModel) {
		RetornoModel retornoModel = new RetornoModel();
		try {
			
			Cliente clienteEntity = (Cliente) converterDTO.converterToModel(clienteModel, Cliente.class);		
			Cliente clienteRetorno = clienteRepository.save(clienteEntity);
			if (clienteRetorno.getCodigoCliente() == null) {
				retornoModel.setCodigo(1);
				retornoModel.setMensaje("NO SE PUDO GUARDAR!!");
			} else {
				retornoModel.setCodigo(0);
				retornoModel.setMensaje("REGISTRO GUARDADO!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retornoModel;

	}
	
	@Override
	public Optional<Cliente> listarClientePorCodigo(Integer cliente) {				
		return  clienteRepository.findById(cliente);		
	} 

}
