package com.mihuella;

import lombok.Getter;
import lombok.Setter;

public class FactorDeEmision {
	@Getter @Setter
	private String nombre;
	@Getter @Setter
	private Double valor;

	public FactorDeEmision(String nombre, Double valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
}
