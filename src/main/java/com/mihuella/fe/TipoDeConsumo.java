package com.mihuella.fe;

import lombok.*;
import jakarta.persistence.*;


//Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//JPA
@Entity
@Table(name = "tipo_de_consumo")
public class TipoDeConsumo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	
	public TipoDeConsumo(String nombre) {
		this.nombre = nombre;
	}
	
	

}
