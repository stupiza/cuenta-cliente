package com.api.cuentacliente.utils;

import org.modelmapper.ModelMapper;

public class MHelpers {
	/**
	 * Reemplazo de converter de Entidad - Modelo o Modelo- Entidad
	 * @return
	 */
	public static ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
