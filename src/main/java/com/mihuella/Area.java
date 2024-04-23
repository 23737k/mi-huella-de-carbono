package com.mihuella;
import lombok.*;

public class Area {
	
	@Getter @Setter
	private String nombre;

	public Area(String nombre) {
		this.nombre = nombre;
	}
}
