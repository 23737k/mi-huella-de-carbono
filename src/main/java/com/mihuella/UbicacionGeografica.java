package com.mihuella;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UbicacionGeografica {
	private String latitud;
	private String longitud;

	public UbicacionGeografica(String latitud, String longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}

}
