package com.mihuella;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "parametros")
public class Parametro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private int id;
	@Getter @Setter
	@ManyToOne(cascade = CascadeType.ALL)
	private Actividad actividad;
	@Getter @Setter
	private String tipoDeConsumo;
	@Getter @Setter
	private Double fe;

	// CONSTRUCTOR SIN PARAMETROS
	public Parametro() {
	}

	public Parametro(Actividad actividad, String tipoDeConsumo, Double fe) {
		this.tipoDeConsumo = tipoDeConsumo;
		this.fe = fe;
		this.actividad = actividad;
	}

	
}
