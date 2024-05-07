package com.mihuella.miembro;

import com.mihuella.organizacion.Organizacion;
import com.mihuella.utils.TipoDoc;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import lombok.*;
import java.util.List;

//Lombok
@Getter
@Setter
@NoArgsConstructor
//JPA
@Entity
@Table(name = "miembro")
public class Miembro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	@Enumerated(EnumType.STRING)
	private TipoDoc tipoDeDocumento;
	private String nroDocumento;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "miembro_id")
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

	public double calcularHuella(Organizacion organizacion){
		LugarDeTrabajo lugarDeTrabajo = lugaresDeTrabajo.stream().filter(l -> l.getOrganizacion().equals(organizacion)).findFirst().orElse(null);
		if(lugarDeTrabajo==null) throw new RuntimeException("No se encontro la organizacion");
		return lugarDeTrabajo.calcularHuella();
	}


}
