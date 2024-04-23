package com.mihuella;

import lombok.*;
import java.util.List;

public class Miembro {
	@Getter
	@Setter
	private String nombre;
	@Getter
	@Setter
	private String apellido;
	@Getter
	@Setter
	private TipoDoc tipoDeDocumento;
	@Getter
	@Setter
	private String nroDocumento;
	@Getter
	@Setter
	private List<LugarDeTrabajo> lugaresDeTrabajo;

	public Miembro(String nombre, String apellido, TipoDoc tipoDeDocumento, String nroDocumento,
			List<LugarDeTrabajo> lugaresDeTrabajo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDeDocumento = tipoDeDocumento;
		this.nroDocumento = nroDocumento;
		this.lugaresDeTrabajo = lugaresDeTrabajo;
	}

}
