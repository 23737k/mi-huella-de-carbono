package my_app.Mi_Huella;

import java.util.List;

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


	//region getters-setters
	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public String getCuil() {
		return cuil;
	}


	public void setCuil(String cuil) {
		this.cuil = cuil;
	}


	public TipoDeOrganizacion getTipoDeOrganizacion() {
		return tipoDeOrganizacion;
	}


	public void setTipoDeOrganizacion(TipoDeOrganizacion tipoDeOrganizacion) {
		this.tipoDeOrganizacion = tipoDeOrganizacion;
	}


	public Clasificacion getClasificacion() {
		return clasificacion;
	}


	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}


	public UbicacionGeografica getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(UbicacionGeografica ubicacion) {
		this.ubicacion = ubicacion;
	}


	public List<Sector> getSectores() {
		return sectores;
	}


	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}


//	public List<Area> getAreas() {
//		return areas;
//	}
//
//
//	public void setAreas(List<Area> areas) {
//		this.areas = areas;
//	}


	public List<Miembro> getMiembros() {
		return miembros;
	}


	public void setMiembros(List<Miembro> miembros) {
		this.miembros = miembros;
	}
	//endregion getters-setters
	

}
