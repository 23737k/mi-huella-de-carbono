package com.mihuella.fe;

import jakarta.persistence.*;
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

	public Actividad (String nombre) {
		this.nombre = nombre;
	}

}
