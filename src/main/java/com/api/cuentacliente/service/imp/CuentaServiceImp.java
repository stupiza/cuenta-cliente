package com.api.cuentacliente.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.api.cuentacliente.entity.Cuenta;
import com.api.cuentacliente.model.CuentaModel;
import com.api.cuentacliente.model.CuentaModelRequest;
import com.api.cuentacliente.model.RetornoModel;
import com.api.cuentacliente.repository.CuentaRepository;
import com.api.cuentacliente.service.ICuentaService;
import com.api.cuentacliente.utils.ConverterDTO;

@Service("cuentaService")
public class CuentaServiceImp implements ICuentaService{

	@Autowired()
	@Qualifier("cuentaRepository")
	CuentaRepository cuentaRepository;

	@Autowired
	@Qualifier("converterDTO")
	private ConverterDTO converterDTO;

	/**
	 * Listar todas las cuentas
	 */
	@Override
	public CuentaModelRequest listarCuentas() {
		CuentaModelRequest cuentaModelRequest = new CuentaModelRequest();
		List<CuentaModel> listacuentaModel = new ArrayList<>();
		List<Cuenta> resultadoCuenta = cuentaRepository.findAll();
		
		RetornoModel retornoModel = new RetornoModel();
		try {

			if (resultadoCuenta.isEmpty()) {
				retornoModel.setCodigo(1);
				retornoModel.setMensaje("NO EXISTEN REGISTROS!!");
				cuentaModelRequest.setMensaje(retornoModel);
				return cuentaModelRequest;
			}
			for (Cuenta cuenta : resultadoCuenta) {
				CuentaModel pmi = (CuentaModel) converterDTO.converterToModel(cuenta, CuentaModel.class);
				listacuentaModel.add(pmi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		retornoModel.setCodigo(0);
		retornoModel.setMensaje("RECUPERADOS!!");
		cuentaModelRequest.setMensaje(retornoModel);
		cuentaModelRequest.setCuenta(listacuentaModel);
		return cuentaModelRequest;
	}

	/**
	 * Registro de nueva cuenta
	 */
	@Override
	public RetornoModel registrarCuenta(CuentaModel cuentaModel) {
		RetornoModel retornoModel = new RetornoModel();
		try {
			
			Cuenta cuentaEntity = (Cuenta) converterDTO.converterToModel(cuentaModel, Cuenta.class);
			Cuenta cuentaRetorno = cuentaRepository.save(cuentaEntity);
			if (cuentaRetorno.getCodigoCuenta() == null) {
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
	public List<Cuenta> listarCuentasPorCliente(Integer cliente) {				
		return  cuentaRepository.findCuentaByCliente(cliente);		
	} 
	
	@Override
	public Optional<Cuenta> listarCuentasPorCodigo(Integer cuenta) {				
		return  cuentaRepository.findById(cuenta);		
	} 
	

}
