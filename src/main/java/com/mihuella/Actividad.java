package com.mihuella;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "actividad")
@Getter
@Setter
@NoArgsConstructor
public class Actividad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	public Actividad (String nombre) {
		this.nombre = nombre;
	}
	
}
