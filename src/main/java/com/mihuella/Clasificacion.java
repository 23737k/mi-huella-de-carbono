package com.mihuella;
import lombok.*;

public class Clasificacion {
	@Getter @Setter
	private String nombre;

	public Clasificacion(String nombre) {
		this.nombre = nombre;
	}

}
