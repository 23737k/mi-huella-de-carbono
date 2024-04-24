package com.mihuella;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



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
