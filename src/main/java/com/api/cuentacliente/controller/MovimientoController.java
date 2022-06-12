package com.api.cuentacliente.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.cuentacliente.model.MovimientoModel;
import com.api.cuentacliente.model.MovimientoModelRequest;
import com.api.cuentacliente.model.ReporteModelRequest;
import com.api.cuentacliente.model.RetornoModel;
import com.api.cuentacliente.service.IMovimientoService;



@RestController
@RequestMapping("/api/movimiento")
public class MovimientoController {
	
	@Autowired	
	private IMovimientoService movimientoServiceImp;

	public static Log log = LogFactory.getLog(CuentaController.class);

	@PostMapping("/registrar")
	public RetornoModel ingresarMovimiento(@RequestBody MovimientoModel movimientoModel) {
		return movimientoServiceImp.registrarMovimiento(movimientoModel);
	}

	@GetMapping("/listar")
	public MovimientoModelRequest listarMovimientos() {
		return movimientoServiceImp.listarMovimientos();
	}
	
	@GetMapping("/reportes/{fechaDesde}/{fechaHasta}/{cliente}")
	public ReporteModelRequest listarMovimientosPorFechaCliente(@PathVariable(name = "fechaDesde")String fechaDesde, @PathVariable(name = "fechaHasta")String fechaHasta,
			@PathVariable(name = "cliente")Integer cliente) {			
		return movimientoServiceImp.reportarMovimientosPorFechaCliente(fechaDesde, fechaHasta, cliente);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public RetornoModel eliminarMovimiento(@PathVariable(name = "id")Integer id) {			
		return movimientoServiceImp.eliminarMovimiento(id);
	}

}
