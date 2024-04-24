package com.mihuella;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class LugarDeTrabajo {
	private Organizacion organizacion;
	private Sector sector;

	public LugarDeTrabajo(Organizacion organizacion, Sector sector) {
		this.organizacion = organizacion;
		this.sector = sector;
	}

}
