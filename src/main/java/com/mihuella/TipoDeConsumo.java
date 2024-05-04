package com.mihuella;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;


@Entity
@Table(name = "tipoDeConsumo")
@Getter
@Setter
@NoArgsConstructor
public class TipoDeConsumo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	public TipoDeConsumo(String nombre) {
		this.nombre = nombre;
	}
	
	

}
