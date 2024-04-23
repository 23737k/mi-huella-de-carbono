package com.mihuella;

import java.util.List;
import lombok.*;

public class Organizacion {
	@Getter @Setter
	private int id;
	@Getter @Setter
	private String razonSocial;
	@Getter @Setter
	private String cuil;
	@Getter @Setter
	private TipoDeOrganizacion tipoDeOrganizacion;
	@Getter @Setter
	private Clasificacion clasificacion;
	@Getter @Setter
	private UbicacionGeografica ubicacion;
	@Getter @Setter
	private List<Sector> sectores;
	//private List<Area> areas;
	@Getter @Setter
	private List<Miembro> miembros;

	public Organizacion(String razonSocial, String cuil, TipoDeOrganizacion tipoDeOrganizacion,
											Clasificacion clasificacion, UbicacionGeografica ubicacion,
											List<Sector> sectores /*,List<Area> areas*/, List<Miembro> miembros) {
		this.razonSocial = razonSocial;
		this.cuil = cuil;
		this.tipoDeOrganizacion = tipoDeOrganizacion;
		this.clasificacion = clasificacion;
		this.ubicacion = ubicacion;
		this.sectores = sectores;
//		this.areas = areas;
		this.miembros = miembros;
	}
	

}
