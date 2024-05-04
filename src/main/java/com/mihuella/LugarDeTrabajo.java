package com.mihuella;

import com.mihuella.transporte.Trayecto;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class LugarDeTrabajo {
	private Organizacion organizacion;
	private Sector sector;
	private List<Trayecto> trayectos;

	public LugarDeTrabajo(Organizacion organizacion, Sector sector) {
		this.organizacion = organizacion;
		this.sector = sector;
		this.trayectos = new ArrayList<Trayecto>();
	}

	public void agregarTrayecto(Trayecto trayecto) {
		this.trayectos.add(trayecto);
	}
	public Double calcularHuella(){
		return trayectos.stream().mapToDouble(Trayecto::calcularHuella).sum();
	}

}
