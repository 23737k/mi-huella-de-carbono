package com.mihuella;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class TipoDeOrganizacion {
	private String nombre;


	public TipoDeOrganizacion(String nombre) {
		this.nombre = nombre;
	}
}
