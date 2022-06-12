package com.api.cuentacliente.utils;

import org.springframework.stereotype.Component;

import com.api.cuentacliente.utils.MHelpers;

@Component("converterDTO")
public class ConverterDTO {
    /**
     * Permite convertir la entidad en modelo
     * @param objeto
     * @param clase
     * @return
     */
	public Object converterToModel(Object objeto, Class clase) {
		Object map = MHelpers.modelMapper().map(objeto, clase);
		return map;
	}

}
