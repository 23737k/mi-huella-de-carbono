package com.mihuella;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "factor_de_emision")
@Getter
@Setter
@NoArgsConstructor
public class FactorDeEmision {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Actividad actividad;
	@ManyToOne(cascade = CascadeType.ALL)
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
