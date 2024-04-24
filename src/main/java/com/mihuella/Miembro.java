package com.mihuella;

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
		
		lugaresDeTrabajo.forEach(lugar -> lugar.getOrganizacion().agregarPostulacion(this));
	}

}
