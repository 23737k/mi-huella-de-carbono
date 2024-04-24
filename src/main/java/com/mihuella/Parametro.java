package com.mihuella;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "parametro")
@Getter
@Setter
@NoArgsConstructor
public class Parametro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Actividad actividad;
	@ManyToOne(cascade = CascadeType.ALL)
	private TipoDeConsumo tipoDeConsumo;
	private Double fe;
	private String unidad;
	

	public Parametro(Actividad actividad, TipoDeConsumo tipoDeConsumo, Double fe, String unidad) {
		this.tipoDeConsumo = tipoDeConsumo;
		this.fe = fe;
		this.actividad = actividad;
		this.unidad = unidad;
	}

	
}
