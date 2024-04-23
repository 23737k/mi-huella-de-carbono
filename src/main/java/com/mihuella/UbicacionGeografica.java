package com.mihuella;

import lombok.Getter;
import lombok.Setter;

public class UbicacionGeografica {
	@Getter @Setter
	private String latitud;
	@Getter @Setter
	private String longitud;

	public UbicacionGeografica(String latitud, String longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}

}
