package com.api.cuentacliente.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
/**
 * Manejador automatico de exepciones
 * @author usuario
 *
 */
@ControllerAdvice  //escucha si se presenta alguna excepcion en todos los controladores automatico
@RestController
public class ResponseExceptionHandler {
	
	@ExceptionHandler(DataIntegrityViolationException.class)//escucha siempre el manejador de excepiones
	@ResponseStatus(HttpStatus.CONFLICT)  //escucha siempre el manejador de excepiones
	public ResponseEntity<Object> conflict(DataIntegrityViolationException ex){//manejo de errores personalizado
		ResponseException response = new ResponseException(HttpStatus.CONFLICT.value(), "Conflicto",ex.getMessage());
		
		return new ResponseEntity<Object>(response, HttpStatus.CONFLICT);
	}

}
