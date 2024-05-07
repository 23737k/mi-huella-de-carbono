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
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Actividad actividad;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private TipoDeConsumo tipoDeConsumo;
	private Double valor;
	private String unidad;
	

	public FactorDeEmision(Actividad actividad, TipoDeConsumo tipoDeConsumo, Double valor, String unidad) {
		this.tipoDeConsumo = tipoDeConsumo;
		this.valor = valor;
		this.actividad = actividad;
		this.unidad = unidad;
	}

	
}
