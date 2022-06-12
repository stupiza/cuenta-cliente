package com.api.cuentacliente.exception;

/**
 * Clase para controlar las excepciones personalizadas
 * 
 * @author usuario
 *
 */
public class ResponseException {

	private Integer status;
	private String mensaje;
	private String detalle;

	public ResponseException(Integer status, String mensaje, String detalle) {
		this.status = status;
		this.mensaje = mensaje;
		this.detalle = detalle;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}
