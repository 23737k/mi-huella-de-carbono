package com.mihuella;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Organizacion {
	private int id;
	private String razonSocial;
	private String cuil;
	private TipoDeOrganizacion tipoDeOrganizacion;
	private Clasificacion clasificacion;
	private UbicacionGeografica ubicacion;
	private List<Sector> sectores;
	//private List<Area> areas;
	private List<Miembro> miembros;
	private List<Medicion> mediciones; 
	private List<Miembro> postulaciones;

	public Organizacion(String razonSocial, String cuil, TipoDeOrganizacion tipoDeOrganizacion,
											Clasificacion clasificacion, UbicacionGeografica ubicacion,
											List<Sector> sectores /*,List<Area> areas*/, List<Miembro> miembros, List<Medicion> mediciones) {
		this.razonSocial = razonSocial;
		this.cuil = cuil;
		this.tipoDeOrganizacion = tipoDeOrganizacion;
		this.clasificacion = clasificacion;
		this.ubicacion = ubicacion;
		this.sectores = sectores;
//		this.areas = areas;
		this.miembros = miembros;
		this.mediciones = mediciones;
		this.postulaciones = new ArrayList<Miembro>();
	}
	
	//TODO cambiar a batch de mediciones
	
	public void agregarMediciones(List<Medicion> mediciones) {
		mediciones.forEach(medicion -> this.mediciones.add(medicion));
	}
	
	public void agregarPostulacion(Miembro miembro) {
		if(!miembros.contains(miembro))
			postulaciones.add(miembro);			
	}
	
	public void aceptarVinculacion(Miembro miembro) {
		postulaciones.remove(miembro);
		miembros.add(miembro);
	}
}
