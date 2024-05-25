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
@Table(name = "factor_de_emision")
public class FactorDeEmision {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//	private Actividad actividad;
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Double valor;
	

	public FactorDeEmision(/*Actividad actividad, TipoDeConsumo tipoDeConsumo,*/ Double valor) {
		//this.tipoDeConsumo = tipoDeConsumo;
		this.valor = valor;
		//this.actividad = actividad;
	}

	
}
