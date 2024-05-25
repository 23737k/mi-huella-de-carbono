package com.mihuella.fe;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

//Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//JPA
@Entity
@Table(name = "actividad")
public class Actividad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	@OneToMany
	@JoinColumn(name = "actividad_id")
	private List<TipoDeConsumo> tiposDeConsumo;

	public Actividad (String nombre) {
		this.nombre = nombre;
	}

}
