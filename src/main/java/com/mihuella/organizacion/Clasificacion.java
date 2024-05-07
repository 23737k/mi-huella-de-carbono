package com.mihuella.organizacion;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

//Lombok
@Getter
@Setter
@NoArgsConstructor
//JPA
@Entity
@Table(name = "clasificacion")
public class Clasificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;

	public Clasificacion(String nombre) {
		this.nombre = nombre;
	}

}
