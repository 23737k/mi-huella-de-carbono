package com.mihuella;

import java.util.ArrayList;
import java.util.Optional;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Miembro {
	private String nombre;
	private String apellido;
	private TipoDoc tipoDeDocumento;
	private String nroDocumento;
	private List<LugarDeTrabajo> lugaresDeTrabajo = new ArrayList<>();

	public Miembro(String nombre, String apellido, TipoDoc tipoDeDocumento, String nroDocumento,
			List<LugarDeTrabajo> lugaresDeTrabajo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDeDocumento = tipoDeDocumento;
		this.nroDocumento = nroDocumento;
		this.lugaresDeTrabajo = lugaresDeTrabajo;
		lugaresDeTrabajo.forEach(lugar -> lugar.getOrganizacion().agregarPostulacion(this));
	}

	public Double calcularHuella(Organizacion organizacion){
		Optional<LugarDeTrabajo> organizacion1 = lugaresDeTrabajo.stream().filter(l -> l.getOrganizacion().equals(organizacion)).findFirst();
		if(organizacion1.isEmpty()) throw new RuntimeException("No se encontro la organizacion");
		LugarDeTrabajo lugar = organizacion1.get();
		return lugar.calcularHuella();
	}


}
