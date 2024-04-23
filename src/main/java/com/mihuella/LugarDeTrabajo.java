package com.mihuella;

import lombok.*;

public class LugarDeTrabajo {
	@Getter
	@Setter
	private Organizacion organizacion;
	@Getter
	@Setter
	private Area area;

	public LugarDeTrabajo(Organizacion organizacion, Area area) {
		this.organizacion = organizacion;
		this.area = area;
	}

}
