package com.mihuella.organizacion;

import com.mihuella.miembro.LugarDeTrabajo;
import com.mihuella.fe.Medicion;
import com.mihuella.miembro.Miembro;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.*;

//Lombok
@Getter
@Setter
@NoArgsConstructor
//JPA
@Entity
@Table(name= "organizacion")
public class Organizacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String razonSocial;
	private String cuil;
	@ManyToOne
	private TipoDeOrganizacion tipoDeOrganizacion;
	@ManyToOne
	private Clasificacion clasificacion;
	private String direccion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "organizacion")
	private List<Sector> sectores;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "organizacion_id")
	private List<Medicion> mediciones;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "organizacion_postulante", joinColumns = {@JoinColumn(name = "organizacion_id")},
			inverseJoinColumns = {@JoinColumn(name = "postulante_id")})
	private List<Miembro> postulaciones;

	public Organizacion(String razonSocial, String cuil, TipoDeOrganizacion tipoDeOrganizacion,
											Clasificacion clasificacion, String direccion) {
		this.razonSocial = razonSocial;
		this.cuil = cuil;
		this.tipoDeOrganizacion = tipoDeOrganizacion;
		this.clasificacion = clasificacion;
		this.direccion = direccion;
		this.sectores = new ArrayList<>();
		this.mediciones = new ArrayList<>();
		this.postulaciones = new ArrayList<Miembro>();
	}
	
	//TODO cambiar a batch de mediciones
	
	public void agregarMediciones(List<Medicion> mediciones) {
    this.mediciones.addAll(mediciones);
	}
	
	public void agregarPostulacion(Miembro miembro) {
		if(!postulaciones.contains(miembro))
			postulaciones.add(miembro);
	}
	
	public void aceptarVinculacion(Miembro miembro) {
		postulaciones.remove(miembro);
		LugarDeTrabajo
        lugarDeTrabajo = miembro.getLugaresDeTrabajo().stream().filter(l -> l.getOrganizacion().equals(this)).findFirst().orElse(null);
		if(lugarDeTrabajo==null) {
			throw new RuntimeException("Lugar de trabajo no encontrado");
		}
		Sector sector = lugarDeTrabajo.getSector();
		if(sector.getMiembros().contains(miembro)) {
			throw new RuntimeException("El miembro ya existe en el sector");
		}
		sector.agregarMiembro(miembro);
	}

	public Double calcularHuellaTransporte() {
		return sectores.stream().mapToDouble(Sector::calcularHuella).sum();
	}

	public List<Miembro> getMiembros() {
		return this.sectores.stream().flatMap(sector -> sector.getMiembros().stream()).collect(Collectors.toList());
	}
	public void agregarSector(Sector sector) {
		this.sectores.add(sector);
	}
	public void agregarSectores(List<Sector> sectores) {
		this.sectores.addAll(sectores);
	}
}
