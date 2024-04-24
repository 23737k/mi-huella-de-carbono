package com.mihuella;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Area {
	
	private String nombre;

	public Area(String nombre) {
		this.nombre = nombre;
	}
}
