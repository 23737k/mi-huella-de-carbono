package com.mihuella.miembro;

import com.mihuella.organizacion.Organizacion;
import com.mihuella.organizacion.Sector;
import com.mihuella.transporte.Trayecto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

//Lombok
@Getter
@Setter
@NoArgsConstructor
//JPA
@Entity
@Table(name="lugar_de_trabajo")
public class LugarDeTrabajo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Organizacion organizacion;
	@ManyToOne
	private Sector sector;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "lugar_de_trabajo_id")
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
