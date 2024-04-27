package com.mihuella;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TipoDeVehiculo {
  private String nombre;

  public TipoDeVehiculo(String nombre) {
    this.nombre = nombre;
  }
}
