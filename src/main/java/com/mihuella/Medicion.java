package com.mihuella;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

public class Medicion {
  @CsvBindByName(column = "actividad")
  @Getter @Setter
  private String actividad;
  @CsvBindByName(column = "tipo-de-consumo")
  @Getter @Setter
  private String tipoDeConsumo;
  @CsvBindByName(column = "valor-consumo")
  @Getter @Setter
  private Double valorConsumo;
  @CsvBindByName(column = "periodicidad-consumo")
  @Getter @Setter
  private Periodicidad periodicidadConsumo;
  @CsvBindByName(column = "periodo-de-imputacion")
  @Getter @Setter
  private String periodoDeImputacion;

  public Medicion(String actividad, String tipoDeConsumo, Double valorConsumo,
                  Periodicidad periodicidadConsumo, String periodoDeImputacion) {
    this.actividad = actividad;
    this.tipoDeConsumo = tipoDeConsumo;
    this.valorConsumo = valorConsumo;
    this.periodicidadConsumo = periodicidadConsumo;
    this.periodoDeImputacion = periodoDeImputacion;
  }

  public Medicion() {
  }

}

