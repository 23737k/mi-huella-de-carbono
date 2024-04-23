package com.mihuella;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Entity
@Table(name = "actividades")
public class Actividad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private int id;
	@Getter
	@Setter
	private String nombre;
	
	public Actividad (String nombre) {
		this.nombre = nombre;
	}
	public Actividad() {}
}
