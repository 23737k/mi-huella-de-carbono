package com.mihuella;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Medicion {
  private Actividad actividad;
  private TipoDeConsumo tipoDeConsumo;
  private Double valorConsumo;
  private Periodicidad periodicidadConsumo;
  private String periodoDeImputacion;

  public Medicion(Actividad actividad, TipoDeConsumo tipoDeConsumo, Double valorConsumo,
                  Periodicidad periodicidadConsumo, String periodoDeImputacion) {
    this.actividad = actividad;
    this.tipoDeConsumo = tipoDeConsumo;
    this.valorConsumo = valorConsumo;
    this.periodicidadConsumo = periodicidadConsumo;
    this.periodoDeImputacion = periodoDeImputacion;
  }


}

