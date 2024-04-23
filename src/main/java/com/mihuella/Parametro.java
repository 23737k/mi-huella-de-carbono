package com.mihuella;

import com.opencsv.bean.CsvBindByName;
import javax.persistence.*;

@Entity
@Table(name = "parametros")
public class Parametro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@CsvBindByName(column = "tipo-de-consumo")
	private String tipoDeConsumo;
	@CsvBindByName
	private Double fe;

	// CONSTRUCTOR SIN PARAMETROS
	public Parametro() {
	}

	public Parametro(String tipoDeConsumo, Double fe) {
		this.tipoDeConsumo = tipoDeConsumo;
		this.fe = fe;
	}

	// region getters y setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipoDeConsumo() {
		return tipoDeConsumo;
	}

	public void setTipoDeConsumo(String tipoDeConsumo) {
		this.tipoDeConsumo = tipoDeConsumo;
	}

	public Double getFe() {
		return fe;
	}

	public void setFe(Double fe) {
		this.fe = fe;
	}
	// endregion getters y setters

}
