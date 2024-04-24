package com.mihuella;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
public class Clasificacion {
	private String nombre;

	public Clasificacion(String nombre) {
		this.nombre = nombre;
	}

}
