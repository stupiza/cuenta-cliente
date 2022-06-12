package com.api.cuentacliente.service.imp;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.api.cuentacliente.entity.Cliente;
import com.api.cuentacliente.entity.Cuenta;
import com.api.cuentacliente.entity.Movimiento;

import com.api.cuentacliente.model.MovimientoModel;
import com.api.cuentacliente.model.MovimientoModelRequest;
import com.api.cuentacliente.model.ReporteCuentaModel;
import com.api.cuentacliente.model.ReporteModel;
import com.api.cuentacliente.model.ReporteModelRequest;
import com.api.cuentacliente.model.ReporteMovimientoModel;
import com.api.cuentacliente.model.RetornoModel;

import com.api.cuentacliente.repository.MovimientoRepository;
import com.api.cuentacliente.service.IClienteService;
import com.api.cuentacliente.service.ICuentaService;
import com.api.cuentacliente.service.IMovimientoService;
import com.api.cuentacliente.utils.ConverterDTO;

@Service("movimientoService")
public class MovimientoServiceImp implements IMovimientoService {

	@Autowired()
	@Qualifier("movimientoRepository")
	MovimientoRepository movimientoRepository;

	@Autowired()
	IClienteService clienteService;

	@Autowired()
	ICuentaService cuentaService;

	@Autowired
	@Qualifier("converterDTO")
	private ConverterDTO converterDTO;

	static final Double MONTODIARIO = 1000.00;
	static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public MovimientoModelRequest listarMovimientos() {
		MovimientoModelRequest movimientoModelRequest = new MovimientoModelRequest();
		List<MovimientoModel> listaMovimientoModel = new ArrayList<>();
		List<Movimiento> resultadoMovimiento = movimientoRepository.findAll();
		
		RetornoModel retornoModel = new RetornoModel();
		try {

			if (resultadoMovimiento.isEmpty()) {
				retornoModel.setCodigo(1);
				retornoModel.setMensaje("NO EXISTEN REGISTROS!!");
				movimientoModelRequest.setMensaje(retornoModel);
				return movimientoModelRequest;
			}
			for (Movimiento movimiento : resultadoMovimiento) {
				MovimientoModel pmi = (MovimientoModel) converterDTO.converterToModel(movimiento,
						MovimientoModel.class);
				listaMovimientoModel.add(pmi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		retornoModel.setCodigo(0);
		retornoModel.setMensaje("RECUPERADOS!!");
		movimientoModelRequest.setMensaje(retornoModel);
		movimientoModelRequest.setMovimiento(listaMovimientoModel);
		return movimientoModelRequest;
	}

	@Override
	public RetornoModel registrarMovimiento(MovimientoModel movimientoModel) {
		RetornoModel retornoModel = new RetornoModel();
		double valorConSigno = movimientoModel.getValorMovimiento();		
		try {
			String fechaMovimiento = sdf.format(movimientoModel.getFechaMovimiento());
			movimientoModel.setFechaMovimiento(sdf.parse(fechaMovimiento));
			Optional<Cuenta> cuenta = cuentaService.listarCuentasPorCodigo(movimientoModel.getCodigoCuenta());
			if (cuenta.isPresent()) {
				if (movimientoModel.getTipoMovimiento().equals("D")) {
					if (cuenta.get().getSaldoCuenta().compareTo(movimientoModel.getValorMovimiento()) < 0) {
						retornoModel.setCodigo(1);
						retornoModel.setMensaje("SALDO NO DISPONIBLE!!");
						return retornoModel;
					}

					Double cupo = acumularMovimiento(cuenta.get().getCodigoCuenta())
							+ movimientoModel.getValorMovimiento();
					if (cupo.compareTo(MONTODIARIO) > 0) {
						retornoModel.setCodigo(1);
						retornoModel.setMensaje("CUPO DIARIO EXCEDIDO!!");
						return retornoModel;
					}
					
					valorConSigno = valorConSigno * -1;
					cuenta.get().setSaldoCuenta(cuenta.get().getSaldoCuenta() - movimientoModel.getValorMovimiento());
				} else {
					cuenta.get().setSaldoCuenta(cuenta.get().getSaldoCuenta() + movimientoModel.getValorMovimiento());
				}
				
			} else {
				retornoModel.setCodigo(1);
				retornoModel.setMensaje("NO EXISTE CUENTA!!");
				return retornoModel;
			}
			movimientoModel.setValorMovimiento(valorConSigno);
			movimientoModel.setSaldoMovimiento(cuenta.get().getSaldoCuenta());
			Movimiento cuentaEntity = (Movimiento) converterDTO.converterToModel(movimientoModel, Movimiento.class);
			Movimiento cuentaRetorno = movimientoRepository.save(cuentaEntity);
			if (cuentaRetorno.getCodigoMovimiento() == null) {
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

	private Double acumularMovimiento(Integer cuenta) {
		Double suma = 0.0;
		try {
			List<Movimiento> movimientoCuenta = movimientoRepository.findMovimientoByCuentaDebito(cuenta);
			for (Movimiento movimiento : movimientoCuenta) {
				suma += Math.abs(movimiento.getValorMovimiento());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return suma;
	}

	@Override
	public ReporteModelRequest reportarMovimientosPorFechaCliente(String fechaDesde, String fechaHasta,
			Integer cliente) {
		RetornoModel retornoModel = new RetornoModel();
		ReporteModel reporteModel = new ReporteModel();
		List<ReporteMovimientoModel> listaMovimiento = new ArrayList<>();
		List<ReporteCuentaModel> listaCuentaCliente = new ArrayList<>();
		List<ReporteModel> listaReporteModel = new ArrayList<>();

		ReporteModelRequest reporteModelRequest = new ReporteModelRequest();
		try {
			Date fechaInicial = sdf.parse(fechaDesde);
			Date fechaFinal = sdf.parse(fechaHasta);			
			if (fechaInicial.compareTo(fechaFinal) > 0) {

				retornoModel.setCodigo(1);
				retornoModel.setMensaje("INCOSISTENCIA EN FECHAS!!");
				reporteModelRequest.setMensaje(retornoModel);
				return reporteModelRequest;
			}

			Optional<Cliente> listCliente = clienteService.listarClientePorCodigo(cliente);
			if (listCliente.isPresent()) {
				List<Cuenta> listaCuenta = cuentaService.listarCuentasPorCliente(cliente);
				for (Cuenta cuenta : listaCuenta) {
					ReporteCuentaModel reporteCuentaModel = new ReporteCuentaModel();
					reporteCuentaModel.setNumeroCuenta(cuenta.getNumeroCuenta());
					reporteCuentaModel.setTipoCuenta(cuenta.getTipoCuenta());
					reporteCuentaModel.setSaldoInicial(cuenta.getSaldoCuenta());
					reporteCuentaModel.setEstado(cuenta.isEstadoCuenta());
					List<Movimiento> listaMovimientoCuenta = movimientoRepository
							.findMovimientoByCuenta(cuenta.getCodigoCuenta(), fechaInicial, fechaFinal);
					for (Movimiento movimiento : listaMovimientoCuenta) {
						ReporteMovimientoModel reporteMovimientoModel = new ReporteMovimientoModel();
						String fechaMovimiento = sdf.format(movimiento.getFechaMovimiento());
						reporteMovimientoModel.setFecha(fechaMovimiento);
						reporteMovimientoModel.setMovimiento(movimiento.getValorMovimiento());
						reporteMovimientoModel.setSaldoDisponible(movimiento.getSaldoMovimiento());
						listaMovimiento.add(reporteMovimientoModel);
					}
					reporteCuentaModel.setMovimiento(listaMovimiento);
					listaCuentaCliente.add(reporteCuentaModel);
				}
				reporteModel.setCliente(listCliente.get().getNombre());
				reporteModel.setCuenta(listaCuentaCliente);
				listaReporteModel.add(reporteModel);
			} else {
				retornoModel.setCodigo(1);
				retornoModel.setMensaje("NO EXISTE CLIENTE!!");
				reporteModelRequest.setMensaje(retornoModel);
				return reporteModelRequest;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		retornoModel.setCodigo(0);
		retornoModel.setMensaje("REGISTROS RECUPERADOS!!");
		reporteModelRequest.setMensaje(retornoModel);
		reporteModelRequest.setMovimiento(listaReporteModel);
		return reporteModelRequest;

	}
	
	@Override
	public RetornoModel eliminarMovimiento(Integer id) {
		RetornoModel retornoModel = new RetornoModel();
		try {
			movimientoRepository.deleteById(id);
			retornoModel.setCodigo(1);
			retornoModel.setMensaje("REGISTRO ELIMINADO!!");
		} catch (Exception e) {
			// TODO: handle exception
		}				
		return retornoModel;
	}

}
