package com.mihuella;

import lombok.*;

public class TipoDeOrganizacion {
	@Getter @Setter
	private String nombre;


	public TipoDeOrganizacion(String nombre) {
		this.nombre = nombre;
	}
}
