package com.mihuella;

import java.util.ArrayList;
import java.util.Optional;
import lombok.*;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

@Getter
@Setter
@NoArgsConstructor
public class Miembro {
	private String nombre;
	private String apellido;
	private TipoDoc tipoDeDocumento;
	private String nroDocumento;
	private List<LugarDeTrabajo> lugaresDeTrabajo;

	public Miembro(String nombre, String apellido, TipoDoc tipoDeDocumento, String nroDocumento,
			List<LugarDeTrabajo> lugaresDeTrabajo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDeDocumento = tipoDeDocumento;
		this.nroDocumento = nroDocumento;
		this.lugaresDeTrabajo = lugaresDeTrabajo;
		//TODO en caso de ser nulo, inicializar con new ArrayList<>()
		lugaresDeTrabajo.forEach(lugar -> lugar.getOrganizacion().agregarPostulacion(this));
	}

	public Double calcularHuella(Organizacion organizacion){
		Optional<LugarDeTrabajo> organizacion1 = lugaresDeTrabajo.stream().filter(l -> l.getOrganizacion().equals(organizacion)).findFirst();
		if(organizacion1.isEmpty()) throw new RuntimeException("No se encontro el lugar de trabajo");
		LugarDeTrabajo lugar = organizacion1.get();
		return lugar.calcularHuella();
	}


}
