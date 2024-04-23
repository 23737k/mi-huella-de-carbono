package com.mihuella;

import com.opencsv.bean.CsvBindByName;

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
	@CsvBindByName(column = "tipo-de-consumo")
	@Getter @Setter
	private String tipoDeConsumo;
	@CsvBindByName
	@Getter @Setter
	private Double fe;

	// CONSTRUCTOR SIN PARAMETROS
	public Parametro() {
	}

	public Parametro(String tipoDeConsumo, Double fe) {
		this.tipoDeConsumo = tipoDeConsumo;
		this.fe = fe;
	}

	
}
